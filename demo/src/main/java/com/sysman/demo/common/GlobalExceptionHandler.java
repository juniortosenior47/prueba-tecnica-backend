package com.sysman.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.sysman.demo.model.APIResponses;

import java.util.Set;

import jakarta.validation.ConstraintViolation;

@ControllerAdvice
public class GlobalExceptionHandler {
        private MaterialErrorLogs apiError;

        public MaterialErrorLogs getApiError() {
                return apiError;
        }

        public void setApiError(MaterialErrorLogs apiError) {
                this.apiError = apiError;
        }

        public void toConsole() {
                ApiUtil.toLogger(this.apiError);
        }


        public ResponseEntity<APIResponses> responseOk() {
                return ResponseEntity.ok().body(ApiUtil.toApiResponse(this.apiError));
        }

        public ResponseEntity<APIResponses> responseBadRequest() {
                return ResponseEntity.badRequest().body(ApiUtil.toApiResponse(this.apiError));
        }

        /**
         * @param ex jakarta.validation.ConstraintViolationException
         * @return ResponseEntity<APIResponses>
         */
        @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
        public ResponseEntity<APIResponses> handleConstraintViolationException(
                        jakarta.validation.ConstraintViolationException ex) {

                Set<jakarta.validation.ConstraintViolation<?>> violations = ex.getConstraintViolations();
                String className = "Undefined";
                String message = "Undefined";
                String propertie = "Undefined";

                // Crear una respuesta personalizada
                for (ConstraintViolation<?> violation : violations) {
                        className = violation.getLeafBean().toString().split("@")[0];
                        message = violation.getMessage();
                        jakarta.validation.Path propertyPath = violation.getPropertyPath();
                        propertie = propertyPath.toString();
                }

                this.setApiError(ApiUtil.toMaterialErrorLogs(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                                className, propertie, message));
                this.toConsole();
                return this.responseBadRequest();
        }

        /**
         * @param ex MissingServletRequestParameterException
         * @return ResponseEntity<APIResponses>
         */
        @ExceptionHandler(MissingServletRequestParameterException.class)
        public ResponseEntity<APIResponses> handleMissingServletRequestParameterException(
                        MissingServletRequestParameterException ex) {

                this.setApiError(ApiUtil.toMaterialErrorLogs(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                                ex.getBody().getClass().getName(), ex.getParameterName(), ex.getMessage()));
                this.toConsole();
                return this.responseBadRequest();
        }

        @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<APIResponses> handleNoResourceFoundException(
                        NoResourceFoundException ex) {

                this.setApiError(ApiUtil.toMaterialErrorLogs(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                                ex.getBody().getClass().getName(), ex.getResourcePath(), ex.getMessage()));
                return this.responseBadRequest();
        }

        /**
         * @param nre jakarta.persistence.NoResultException
         * @return ResponseEntity<APIResponses>
         */
        @ExceptionHandler(jakarta.persistence.NoResultException.class)
        public ResponseEntity<APIResponses> handleNoResourceFoundException(
                        jakarta.persistence.NoResultException nre) {

                this.setApiError(ApiUtil.toMaterialErrorLogs(String.valueOf(HttpStatus.NOT_FOUND.value()),
                                HttpStatus.NOT_FOUND.getReasonPhrase(),
                                jakarta.persistence.NoResultException.class.getName(), "undefind", nre.getMessage()));
                this.toConsole();
                return this.responseOk();
        }

        // org.hibernate.exception.SQLGrammarException
}
