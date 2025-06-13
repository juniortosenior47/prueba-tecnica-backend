package com.sysman.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.sysman.demo.common.MaterialApi;
import com.sysman.demo.model.APIResponses;
import com.sysman.demo.service.MaterialBusiness;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Validated
@Tag(name = "material", description = "the material API")
public class MaterialController implements MaterialApi {
    @Autowired
    private MaterialBusiness mb;

    @Override
    public ResponseEntity<APIResponses> listMaterial() {
        return mb.listMaterial();
    }
}
