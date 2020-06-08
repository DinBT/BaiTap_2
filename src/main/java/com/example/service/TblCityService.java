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
package com.example.service;

import com.example.common.Common;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.reposistories.TblCityReponsitory;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * processing flow to tbl_city
 *
 * @author DinBT
 */
@Service
public class TblCityService {
    @Autowired
    private TblCityReponsitory tblCityReponsitory;

    /**
     * Service for add new data to tbl_city
     *
     * @param jsonData
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertTblCity(String jsonData) {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonData);
        String code = jsonObject.get("code").toString();
        String cityKana = jsonObject.get("city_kana").toString();
        String city = jsonObject.get("city").toString();
        int prefectureId = Integer.parseInt(jsonObject.get("prefecture_id").toString());
        if (!Common.validateSTring(city, cityKana)) {
            throw new BadRequest("Validate Not Passed");
        }
        tblCityReponsitory.insertTblCity(code, cityKana, city, prefectureId);
    }

    /**
     * Service for edit new data to tbl_city
     *
     * @param jsonData
     * @param cityId
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateTblCity(String jsonData, int cityId) {
        if (tblCityReponsitory.getCodeById(cityId) == null) {
            throw new NotFound("Update a tbl_city Record That Not Existed");
        }
        JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonData);
        String code = jsonObject.get("code").toString();
        String cityKana = jsonObject.get("city_kana").toString();
        String city = jsonObject.get("city").toString();
        int prefectureId = Integer.parseInt(jsonObject.get("prefecture_id").toString());
        if (!Common.validateSTring(city, cityKana)) {
            throw new BadRequest("Validate Not Passed");
        }
        tblCityReponsitory.updateTblCity(code, cityKana, city, prefectureId, cityId);
    }

    /**
     * Delete data from tbl_city
     *
     * @param cityId
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteTblCity(int cityId) {
        if (tblCityReponsitory.getCodeById(cityId) == null) {
            throw new NotFound("Delete a tbl_city Record That Not Existed");
        }
        tblCityReponsitory.deleteTblCity(cityId);
    }

}
