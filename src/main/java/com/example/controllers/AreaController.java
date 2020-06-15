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
import com.example.entities.TblAreaEntity;
import com.example.service.TblAreaService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for tbl_area
 *
 * @author DinBT
 */
@RestController
@RequestMapping("address/area")
public class AreaController {

    @Autowired
    private TblAreaService areaService;


    /**
     * add new data into tbl_area
     *
     * @param jsonData data about TblAreaEntity want add
     * @return ResponseEntity<TblAreaEntity>
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<TblAreaEntity> insertTblArea(@RequestBody JSONObject jsonData) {
        TblAreaEntity tblAreaEntity = areaService.saveTblArea(jsonData);
        return new ResponseEntity<>(tblAreaEntity, HttpStatus.OK);
    }

    /**
     * edit new data into tbl_area
     *
     * @param jsonData data about TblAreaEntity want edit
     * @return ResponseEntity<TblAreaEntity>
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<TblAreaEntity> updateTblArea(@RequestBody JSONObject jsonData) {
        TblAreaEntity tblAreaEntity = areaService.updateTblArea(jsonData);
        return new ResponseEntity<>(tblAreaEntity, HttpStatus.OK);
    }

    /**
     * Delete data from tbl_area
     *
     * @param jsonData data about TblAreaEntity want delete
     * @return ResponseEntity<SuccessResult>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessResult> deleteTblArea(@RequestBody JSONObject jsonData) {
        areaService.deleteTblArea(jsonData);
        return new ResponseEntity<>(new SuccessResult("200", "delete record successfully"), HttpStatus.OK);
    }

}
