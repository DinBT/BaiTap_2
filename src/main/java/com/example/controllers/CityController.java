/*
 * Copyright 2015-2016 Classmethod, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All source code, documentation and other information
 * contained herein is, and remains the property of Classmethod, Inc.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Classmethod, Inc.
 */
package com.example.controllers;

import com.example.bean.SuccessResult;
import com.example.entities.TblCityEntity;
import com.example.service.TblCityService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for tbl_city
 *
 * @author DinBT
 */
@RestController
@RequestMapping("address/city")
public class CityController {

    @Autowired
    private TblCityService cityService;


    /**
     * add new data into tbl_city
     *
     * @param jsonData data about TblCityEntity want add
     * @return ResponseEntity<TblCityEntity>
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<TblCityEntity> insertTblCity(@RequestBody JSONObject jsonData) {
        TblCityEntity tblCityEntity = cityService.saveTblCityEntity(jsonData);
        return new ResponseEntity<>(tblCityEntity, HttpStatus.OK);
    }

    /**
     * edit new data into tbl_city
     *
     * @param jsonData data about TblCityEntity want edit
     * @return ResponseEntity<TblCityEntity>
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<TblCityEntity> updateTblCity(@RequestBody JSONObject jsonData) {
        TblCityEntity tblCityEntity = cityService.updateTblCity(jsonData);
        return new ResponseEntity<>(tblCityEntity, HttpStatus.OK);
    }

    /**
     * Delete data from tbl_city
     *
     * @param jsonData data about TblCityEntity want delete
     * @return ResponseEntity<SuccessResult>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessResult> deleteTblCity(@RequestBody JSONObject jsonData) {
        cityService.deleteTblCity(jsonData);
        return new ResponseEntity<>(new SuccessResult("200", "delete record successfully"), HttpStatus.OK);
    }

}
