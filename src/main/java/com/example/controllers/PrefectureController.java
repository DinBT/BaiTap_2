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

import com.example.bean.CityByPrefecture;
import com.example.bean.ListCityResult;
import com.example.bean.SuccessResult;
import com.example.entities.TblPrefectureEntity;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.service.TblPrefectureService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for tbl_prefecture
 *
 * @author DinBT
 */
@RestController
@RequestMapping("address/prefecture")
public class PrefectureController {

    @Autowired
    private TblPrefectureService prefectureService;


    /**
     * add new data into tbl_prefecture
     *
     * @param jsonData data about TblPrefectureEntity want add
     * @return ResponseEntity<TblPrefectureEntity>
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<TblPrefectureEntity> insertTblArea(@RequestBody JSONObject jsonData) {
        TblPrefectureEntity tblPrefectureEntity = prefectureService.insertTblPrefecture(jsonData);
        return new ResponseEntity<>(tblPrefectureEntity, HttpStatus.OK);
    }

    /**
     * edit new data into tbl_prefecture
     *
     * @param jsonData data about TblPrefectureEntity want edit
     * @return ResponseEntity<TblPrefectureEntity>
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<TblPrefectureEntity> updateTblArea(@RequestBody JSONObject jsonData) {
        TblPrefectureEntity tblPrefectureEntity = prefectureService.updateTblPrefecture(jsonData);
        return new ResponseEntity<>(tblPrefectureEntity, HttpStatus.OK);
    }

    /**
     * Delete data from tbl_area
     *
     * @param jsonData data about TblPrefectureEntity want delete
     * @return ResponseEntity<SuccessResult>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessResult> deletePrefecture(@RequestBody JSONObject jsonData) {
        prefectureService.deleteTblPrefecture(jsonData);
        return new ResponseEntity<>(new SuccessResult("200", "deleted record successfully"), HttpStatus.OK);
    }

    /**
     * Solving and response data for request from client if user search by prefectureCode
     *
     * @param prefectureCode: prefectureCode to search
     * @return ResponseEntity<ListCityResult>: list city result
     */
    @RequestMapping(value = "/search/{pr}", method = RequestMethod.GET)
    public ResponseEntity<ListCityResult> searchByPrefectureCode(
            @PathVariable(value = "pr") String prefectureCode) {
        prefectureCode = prefectureCode.replace(" ", "").replace("-", "");
        if (prefectureCode == "" || !(prefectureCode.matches("^[0-9]{1,}$"))) {
            throw new BadRequest("Bad Request");
        }
        List<CityByPrefecture> recordList = prefectureService.searchByPrefectureCode(prefectureCode);
        if (recordList == null || recordList.isEmpty()) {
            throw new NotFound("Not Found");
        }
        return new ResponseEntity<>(new ListCityResult(recordList), HttpStatus.OK);
    }
}
