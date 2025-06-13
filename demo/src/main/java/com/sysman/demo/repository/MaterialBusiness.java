package com.sysman.demo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sysman.demo.common.ApiUtil;
import com.sysman.demo.common.MaterialApi;
import com.sysman.demo.common.MaterialErrorLogs;
import com.sysman.demo.entity.Material;
import com.sysman.demo.model.APIResponses;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class MaterialBusiness implements MaterialApi {
    @Autowired
    private MysqlHandler mysqlJPA;
  
    private MaterialErrorLogs apiError;

    @Override
    @Transactional
    public ResponseEntity<APIResponses> listMaterial() {
        EntityManager entityManager = mysqlJPA.getEntityManagerFactory().createEntityManager();
        // entityManager.unwrap(Connection.class);

        try {
            entityManager.getTransaction().begin();

            TypedQuery<Material> query = entityManager.createQuery("select p from Products p where p.ownerID = ?1",
                    Material.class);
            List<Material> list = query.getResultList();

            entityManager.getTransaction().commit();
            // return CollectionUtils.isEmpty(list) ? null : list;

            if (list.isEmpty() || list.size() == 0) {
                return ResponseEntity.ok(new APIResponses(String.valueOf(HttpStatus.NOT_FOUND.value()),
                        HttpStatus.NOT_FOUND.getReasonPhrase(), LocalDateTime.now().toString(),
                        ApiUtils.toLProduct(list), "/product",
                        UUID.randomUUID().toString()));
            } else {
                return ResponseEntity.ok(new APIResponses(String.valueOf(HttpStatus.OK.value()),
                        HttpStatus.OK.getReasonPhrase(), LocalDateTime.now().toString(),
                        ApiUtils.toLProduct(list), "/product",
                        UUID.randomUUID().toString()));
            }

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            entityManager.close();

            this.apiError = ApiUtils.toProductErrorLogs(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    ProductBusiness.class.getName(), "listProducts", e.getMessage());
            
            productErrorLogsRepository.save(this.apiError);
            
            return ResponseEntity.badRequest().body(ApiUtils.toApiResponse(this.apiError));

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    
}
