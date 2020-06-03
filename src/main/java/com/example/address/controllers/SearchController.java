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
package com.example.address.controllers;

import java.util.List;

import com.example.address.reposistories.SearchByPostCode;
import com.example.address.reposistories.SearchByPrefecture;
import com.example.address.bean.CityByPrefecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.address.bean.AddressByPostCode;

/**
 * Controller for searching
 *
 * @author DinBT
 */
@RestController
@RequestMapping("address")
public class SearchController {

    @Autowired
    private SearchByPostCode postRepository;

    @Autowired
    private SearchByPrefecture prefectureRepository;


    /**
     * Solving and response data for request from client if user search by postCode
     *
     * @param postCode: postCode to search
     * @return String: city found
     */
    @RequestMapping(value = "post/{pc}", method = RequestMethod.GET)
    public String searchByPostCode(@PathVariable(value = "pc") String postCode) {
        postCode = postCode.replaceAll(" ", "").replaceAll("-", "");
        if (postCode == null || !(postCode.matches("^[0-9]{1,}$"))) {
            return "400: BadRequest!";
        }
        AddressByPostCode recordList = postRepository.searchByPostCode(postCode);
        if (recordList == null) {
            return "404: NotFound!!";
        }
        return "{\"data\":[" + recordList.toString() + "],\"result\":\"success\"}";
    }

    /**
     * Solving and response data for request from client if user search by prefectureCode
     *
     * @param prefectureCode: prefectureCode to search
     * @return String: result found
     */
    @RequestMapping(value = "prefecture/{pr}", method = RequestMethod.GET)
    public String searchByPrefectureCode(
            @PathVariable(value = "pr") String prefectureCode) {
        prefectureCode = prefectureCode.replace(" ", "").replace("-", "");
        if (prefectureCode == null || !(prefectureCode.matches("^[0-9]{1,}$"))) {
            return "400: BadRequest!";//HttpStatus.BAD_REQUEST
        }
        List<CityByPrefecture> recordList = prefectureRepository.searchByPrefectureCode(prefectureCode);
        if (recordList == null || recordList.isEmpty()) {
            return "404: NotFound!!";
        }
        StringBuilder result = new StringBuilder();
        recordList.forEach(record -> result.append(record.toString() + ","));
        return "{\"data\":[" + result.toString() + "],\"result\":\"success\"}";
    }
}
