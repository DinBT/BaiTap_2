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
     * @param jsonData
     * @return ResponseEntity<SuccessResult>
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<SuccessResult> insertTblCity(@RequestBody JSONObject jsonData) {
        cityService.insertTblCity(jsonData);
        return new ResponseEntity<>(new SuccessResult("200", "add record successfully"), HttpStatus.OK);
    }

    /**
     * edit new data into tbl_city
     *
     * @param jsonData
     * @return ResponseEntity<SuccessResult>
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity<SuccessResult> updateTblCity(@RequestBody JSONObject jsonData) {
        cityService.updateTblCity(jsonData);
        return new ResponseEntity<>(new SuccessResult("200", "edit record successfully"), HttpStatus.OK);
    }

    /**
     * Delete data from tbl_city
     *
     * @param jsonData
     * @return ResponseEntity<SuccessResult>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<SuccessResult> deleteTblCity(@RequestBody JSONObject jsonData) {
        cityService.deleteTblCity(jsonData);
        return new ResponseEntity<>(new SuccessResult("200", "delete record successfully"), HttpStatus.OK);
    }

}
