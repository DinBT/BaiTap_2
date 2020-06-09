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
    public void insertTblCity(JSONObject jsonData) {
        String code = jsonData.get("code").toString();
        String cityKana = jsonData.get("city_kana").toString();
        String city = jsonData.get("city").toString();
        int prefectureId = Integer.parseInt(jsonData.get("prefecture_id").toString());
        if (!Common.validateSTring(city, cityKana)) {
            throw new BadRequest("Fail validate");
        }
        tblCityReponsitory.insertTblCity(code, cityKana, city, prefectureId);
    }

    /**
     * Service for edit new data to tbl_city
     *
     * @param jsonData
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateTblCity(JSONObject jsonData) {
        int cityId = Integer.parseInt(jsonData.get("city_id").toString());
        if (tblCityReponsitory.getCodeById(cityId) == null) {
            throw new NotFound("Update a tbl_city Record That Not Existed");
        }
        String code = jsonData.get("code").toString();
        String cityKana = jsonData.get("city_kana").toString();
        String city = jsonData.get("city").toString();
        int prefectureId = Integer.parseInt(jsonData.get("prefecture_id").toString());
        if (!Common.validateSTring(city, cityKana)) {
            throw new BadRequest("Fail validate");
        }
        tblCityReponsitory.updateTblCity(code, cityKana, city, prefectureId, cityId);
    }

    /**
     * Delete data from tbl_city
     *
     * @param jsonData
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteTblCity(JSONObject jsonData) {
        int cityId = Integer.parseInt(jsonData.get("city_id").toString());
        if (tblCityReponsitory.getCodeById(cityId) == null) {
            throw new NotFound("Delete a tbl_city Record That Not Existed");
        }
        tblCityReponsitory.deleteTblCity(cityId);
    }

}
