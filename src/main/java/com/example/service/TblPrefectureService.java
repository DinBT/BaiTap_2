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

import com.example.bean.CityByPrefecture;
import com.example.common.Common;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.reposistories.TblPrefectureReponsitory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * processing flow to tbl_prefecture
 *
 * @author DinBT
 */
@Service
public class TblPrefectureService {
    @Autowired
    private TblPrefectureReponsitory prefectureReponsitory;

    /**
     * Service for add new data to tbl_prefecture
     *
     * @param jsonData
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertTblPrefecture(JSONObject jsonData) {
        String prefecture = jsonData.get("prefecture").toString();
        String prefectureKana = jsonData.get("prefecture_kana").toString();
        String prefectureCode = jsonData.get("prefecture_code").toString();
        if (!Common.validateSTring(prefecture, prefectureKana)) {
            throw new BadRequest("Fail validate");
        }
        prefectureReponsitory.insertTblPrefecture(prefectureKana, prefecture, prefectureCode);
    }

    /**
     * Service for edit new data into tbl_prefecture
     *
     * @param jsonData
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateTblPrefecture(JSONObject jsonData) {
        int prefectureId = Integer.parseInt(jsonData.get("prefecture_id").toString());
        if (prefectureReponsitory.getPrefectureKanaById(prefectureId) == null) {
            throw new NotFound("Update a tbl_prefecture Record That Not Existed");
        }
        String prefecture = jsonData.get("prefecture").toString();
        String prefectureKana = jsonData.get("prefecture_kana").toString();
        String prefectureCode = jsonData.get("prefecture_code").toString();
        if (!Common.validateSTring(prefecture, prefectureKana)) {
            throw new BadRequest("Fail validate");
        }
        prefectureReponsitory.updateTblPrefecture(prefecture, prefectureKana, prefectureCode, prefectureId);
    }

    /**
     * Service for deleting data from tbl_prefecture
     *
     * @param jsonData
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteTblPrefecture(JSONObject jsonData) {
        int prefectureId = Integer.parseInt(jsonData.get("prefecture_id").toString());
        if (prefectureReponsitory.getPrefectureKanaById(prefectureId) == null) {
            throw new NotFound("Delete a tbl_prefecture Record That Not Existed");
        }
        prefectureReponsitory.deleteTblPrefecture(prefectureId);
    }

    /**
     * Service for searching by prefectureCode
     *
     * @param prefectureCode
     * @return List<CityByPrefecture>
     */
    public List<CityByPrefecture> searchByPrefectureCode(String prefectureCode) {
        return prefectureReponsitory.searchByPrefectureCode(prefectureCode);
    }

}
