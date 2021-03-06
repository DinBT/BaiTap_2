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

import com.example.bean.AddressByPostCode;
import com.example.bean.AddressResult;
import com.example.bean.PostDto;
import com.example.bean.SuccessResult;
import com.example.entities.TblPostEntity;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.service.TblAreaService;
import com.example.service.TblPostService;
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
 * Controller for tbl_post
 *
 * @author DinBT
 */
@RestController
@RequestMapping("address/post")
public class PostController {

    @Autowired
    private TblPostService postService;

    /**
     * Insert new data to tbl_post
     *
     * @param jsonData data about TblPostEntity want add
     * @return ResponseEntity<TblPostEntity>
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<TblPostEntity> insert(@RequestBody PostDto jsonData) {
        TblPostEntity tblPostEntity = postService.saveTblPost(jsonData);
        return new ResponseEntity<>(tblPostEntity, HttpStatus.OK);
    }

    /**
     * edit new data to tbl_post
     *
     * @param jsonData data about TblPostEntity want edit
     * @return ResponseEntity<TblPostEntity>
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<TblPostEntity> update(@RequestBody PostDto jsonData) {
        TblPostEntity tblPostEntity = postService.updateTblPost(jsonData);
        return new ResponseEntity<>(tblPostEntity, HttpStatus.OK);
    }

    /**
     * Delete data from tbl_post
     *
     * @param postId data about TblPostEntity want delete
     * @return ResponseEntity<SuccessResult>
     */
    @RequestMapping(value = "/delete/{postId}", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessResult> deleteTblPost(@PathVariable(value = "postId") int postId) {
        postService.delete(postId);
        return new ResponseEntity<>(new SuccessResult("200", "delete record successfully"), HttpStatus.OK);
    }

    /**
     * Solving and response data for request from client if user search by postCode
     *
     * @param postCode: postCode to search
     * @return ResponseEntity<AddressResult>: address found
     */
    @RequestMapping(value = "/search/{pc}", method = RequestMethod.GET)
    public ResponseEntity<AddressResult> searchByPostCode(@PathVariable(value = "pc") String postCode) {
        postCode = postCode.replaceAll(" ", "").replaceAll("-", "");
        if (postCode.equals("") || (postCode.matches("^[0-9]{1,}$") == false)) {
            throw new BadRequest("Bad Request");
        }
        List<AddressByPostCode> recordList = postService.searchByPostCode(postCode);
        if (recordList == null || recordList.size() == 0) {
            throw new NotFound("Not Found");
        }
        return new ResponseEntity<>(new AddressResult(recordList), HttpStatus.OK);
    }
}
