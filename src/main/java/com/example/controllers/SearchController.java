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

import java.util.List;

import com.example.bean.AddressResult;
import com.example.bean.ListCityResult;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.bean.CityByPrefecture;
import com.example.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bean.AddressByPostCode;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for searching
 *
 * @author DinBT
 */
@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * Solving and response data for request from client if user search by postCode
     *
     * @param postCode: postCode to search
     * @return ResponseEntity<AddressResult>: address found
     */
    @RequestMapping(value = "/post/{pc}", method = RequestMethod.GET)
    public ResponseEntity<AddressResult> searchByPostCode(@PathVariable(value = "pc") String postCode) {
        postCode = postCode.replaceAll(" ", "").replaceAll("-", "");
        if (postCode.equals("") || !(postCode.matches("^[0-9]{1,}$"))) {
            throw new BadRequest("Bad Request");
        }
        List<AddressByPostCode> recordList = searchService.searchByPostCode(postCode);
        if (recordList == null || recordList.size() == 0) {
            throw new NotFound("Not Found");
        }
        return new ResponseEntity<>(new AddressResult(recordList), HttpStatus.OK);
    }

    /**
     * Solving and response data for request from client if user search by prefectureCode
     *
     * @param prefectureCode: prefectureCode to search
     * @return ResponseEntity<ListCityResult>: list city result
     */
    @RequestMapping(value = "/prefecture/{pr}", method = RequestMethod.GET)
    public ResponseEntity<ListCityResult> searchByPrefectureCode(
            @PathVariable(value = "pr") String prefectureCode) {
        prefectureCode = prefectureCode.replace(" ", "").replace("-", "");
        if (prefectureCode == "" || !(prefectureCode.matches("^[0-9]{1,}$"))) {
            throw new BadRequest("Bad Request");
        }
        List<CityByPrefecture> recordList = searchService.searchByPrefectureCode(prefectureCode);
        if (recordList == null || recordList.isEmpty()) {
            throw new NotFound("Not Found");
        }
        return new ResponseEntity<>(new ListCityResult(recordList), HttpStatus.OK);
    }
}
