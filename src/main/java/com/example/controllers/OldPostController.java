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
import com.example.entities.TblOldPostEntity;
import com.example.service.TblOldPostService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for tbl_old_post
 *
 * @author DinBT
 */
@RestController
@RequestMapping("address/old_post")
public class OldPostController {

    @Autowired
    private TblOldPostService oldPostService;


    /**
     * add new data to tbl_old_post
     *
     * @param jsonData data about TblOlPostEntity want add
     * @return ResponseEntity<TblOldPostEntity>
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TblOldPostEntity> saveTblOldPostEntity(@RequestBody JSONObject jsonData) {
        TblOldPostEntity tblOldPostEntity = oldPostService.saveTblOldPostEntity(jsonData);
        return new ResponseEntity<>(tblOldPostEntity, HttpStatus.OK);
    }

    /**
     * edit new data to tbl_old_post
     *
     * @param jsonData data about TblOlPostEntity want edit
     * @return ResponseEntity<TblOldPostEntity>
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<TblOldPostEntity> updateTblPost(@RequestBody JSONObject jsonData) {
        TblOldPostEntity TblOldPostEntity = oldPostService.updateTblOldPost(jsonData);
        return new ResponseEntity<>(TblOldPostEntity, HttpStatus.OK);
    }

    /**
     * Delete data from tbl_old_post
     *
     * @param jsonData data about TblOlPostEntity want delete
     * @return ResponseEntity<SuccessDto>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessResult> deleteTblPost(@RequestBody JSONObject jsonData) {
        oldPostService.deleteTblOldPost(jsonData);
        return new ResponseEntity<>(new SuccessResult("200", "delete record successfully"), HttpStatus.OK);
    }
}
