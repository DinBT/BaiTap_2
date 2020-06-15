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
import com.example.entities.TblPrefectureEntity;
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
     * @param jsonData data about TblPrefectureEntity want add
     */
    @Transactional(rollbackFor = Exception.class)
    public TblPrefectureEntity insertTblPrefecture(JSONObject jsonData) {
        String prefecture = jsonData.get("prefecture").toString();
        String prefectureKana = jsonData.get("prefecture_kana").toString();
        String prefectureCode = jsonData.get("prefecture_code").toString();
        TblPrefectureEntity tblPrefectureEntity = new TblPrefectureEntity(prefecture, prefectureKana, prefectureCode);
        if (Common.checkKatakana(prefectureKana) == false || prefectureCode.matches(Common.KANJI) == false) {
            throw new BadRequest("Fail validate");
        }
        tblPrefectureEntity = prefectureReponsitory.save(tblPrefectureEntity);
        return tblPrefectureEntity;
    }

    /**
     * Service for edit new data into tbl_prefecture
     *
     * @param jsonData data about TblPrefectureEntity want edit
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public TblPrefectureEntity updateTblPrefecture(JSONObject jsonData) {
        long prefectureId = (long) Integer.parseInt(jsonData.get("prefecture_id").toString());
        if (prefectureReponsitory.findById(prefectureId) == null) {
            throw new NotFound("Update a tbl_prefecture Record That Not Existed");
        }
        String prefecture = jsonData.get("prefecture").toString();
        String prefectureKana = jsonData.get("prefecture_kana").toString();
        String prefectureCode = jsonData.get("prefecture_code").toString();
        if (Common.checkKatakana(prefectureKana) == false || prefectureCode.matches(Common.KANJI) == false) {
            throw new BadRequest("Fail validate");
        }
        prefectureReponsitory.updateTblPrefecture(prefecture, prefectureKana, prefectureCode, prefectureId);
        TblPrefectureEntity tblPrefectureEntity = new TblPrefectureEntity(prefecture, prefectureKana, prefectureCode);
        tblPrefectureEntity.setPrefectureId(prefectureId);
        return tblPrefectureEntity;
    }

    /**
     * Service for deleting data from tbl_prefecture
     *
     * @param jsonData data about TblPrefectureEntity want delete
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteTblPrefecture(JSONObject jsonData) {
        long prefectureId = (long) Integer.parseInt(jsonData.get("prefecture_id").toString());
        if (prefectureReponsitory.findById(prefectureId) == null) {
            throw new NotFound("Delete a tbl_prefecture Record That Not Existed");
        }
        prefectureReponsitory.deleteById(prefectureId);
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
