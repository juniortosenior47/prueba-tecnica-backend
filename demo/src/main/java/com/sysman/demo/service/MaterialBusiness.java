package com.sysman.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sysman.demo.common.ApiUtil;
import com.sysman.demo.common.MaterialApi;
import com.sysman.demo.common.MaterialErrorLogs;
import com.sysman.demo.entity.CityDB;
import com.sysman.demo.entity.CountiesDB;
import com.sysman.demo.entity.MaterialDB;
import com.sysman.demo.model.APIResponses;
import com.sysman.demo.model.APIResponsesDataInner;
import com.sysman.demo.model.Material;
import com.sysman.demo.repository.MysqlHandler;

@Service
public class MaterialBusiness implements MaterialApi {
    @Autowired
    private MysqlHandler mysqlJPA;
    private MaterialErrorLogs apiError;
    private List<Material> lm;

    public MaterialErrorLogs getApiError() {
        return apiError;
    }

    public void setApiError(MaterialErrorLogs apiError) {
        this.apiError = apiError;
    }

    public List<Material> getLm() {
        return lm;
    }

    public void processObtainsMaterial() {
        List<MaterialDB> lMDB = mysqlJPA.allMaterial();
        List<Integer> lICi = lMDB.stream().map(cid -> cid.getCityID()).collect(Collectors.toList());

        List<CityDB> lCiDB = mysqlJPA.cityFindByIdIn(lICi);
        List<Integer> lICo = lCiDB.stream().map(cid -> cid.getCountiesID()).collect(Collectors.toList());

        List<CountiesDB> lCoDB = mysqlJPA.countiesFindByIdIn(lICo);

        this.lm = ApiUtil.toMaterialBy(lMDB, lCiDB, lCoDB);
    }

    public ResponseEntity<APIResponses> responseOk(List<APIResponsesDataInner> data) {
        return ResponseEntity.ok(
                new APIResponses(String.valueOf(HttpStatus.OK.value()), HttpStatus.OK.getReasonPhrase(),
                        LocalDateTime.now().toString(), data, "/material", UUID.randomUUID().toString()));
    }

    public ResponseEntity<APIResponses> responseNotFound(List<APIResponsesDataInner> data) {
        return ResponseEntity.ok(
                new APIResponses(String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND.getReasonPhrase(),
                        LocalDateTime.now().toString(), data, "/material", UUID.randomUUID().toString()));
    }

    public ResponseEntity<APIResponses> responseInternalServerError(Exception e) {
        this.setApiError(ApiUtil.toMaterialErrorLogs(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), MaterialBusiness.class.getName(),
                e.getLocalizedMessage().toString(), e.getMessage()));
        ApiUtil.toLogger(this.apiError);
        return ResponseEntity.ok().body(ApiUtil.toApiResponse(this.apiError));
    }

    @Override
    public ResponseEntity<APIResponses> listMaterial() {
        try {
            this.processObtainsMaterial();

            if (this.getLm().isEmpty() || this.getLm().size() == 0) {
                return this.responseNotFound(this.getLm().stream().collect(Collectors.toList()));
            } else {
                return this.responseOk(this.getLm().stream().collect(Collectors.toList()));
            }

        } catch (Exception e) {
            return responseInternalServerError(e);
        }
    }

}
