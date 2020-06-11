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
import com.example.entities.TblAreaEntity;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.reposistories.TblAreaReponsitory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * processing flow to tbl_area
 *
 * @author DinBT
 */
@Service
public class TblAreaService {

    @Autowired
    private TblAreaReponsitory areaReponsitory;

    /**
     * Service for edit new data into tbl_area
     *
     * @param jsonData data about TblAreaEntity want add
     */
    @Transactional(rollbackFor = Exception.class)
    public TblAreaEntity saveTblArea(JSONObject jsonData) {
        String areaKana = jsonData.get("area_kana").toString();
        String area = jsonData.get("area").toString();
        int cityId = Integer.parseInt(jsonData.get("city_id").toString());
        int chomeArea = Integer.parseInt(jsonData.get("chome_area").toString());
        int koazaArea = Integer.parseInt(jsonData.get("koaza_area").toString());
        int multiPostArea = Integer.parseInt(jsonData.get("multi_post_area").toString());
        int postId = Integer.parseInt(jsonData.get("post_id").toString());
        int oldPostId = Integer.parseInt(jsonData.get("old_post_id").toString());
        TblAreaEntity tblAreaEntity = new TblAreaEntity(area, areaKana, multiPostArea, koazaArea, chomeArea, cityId, oldPostId, postId);
        if (Common.checkKatakana(areaKana) == false || area.matches(Common.KANJI) == false) {
            throw new BadRequest("Fail validate");
        }
        tblAreaEntity = areaReponsitory.save(tblAreaEntity);
        return tblAreaEntity;
    }

    /**
     * Service for edit new data into tbl_area
     *
     * @param jsonData data about TblAreaEntity want edit
     */
    @Transactional(rollbackFor = Exception.class)
    public TblAreaEntity updateTblArea(JSONObject jsonData) {
        long areaId = (long) Integer.parseInt(jsonData.get("area_id").toString());
        if (areaReponsitory.findById(areaId) == null) {
            throw new NotFound("Update a tbl_area Record That Not Existed");
        }
        String areaKana = jsonData.get("area_kana").toString();
        String area = jsonData.get("area").toString();
        int cityId = Integer.parseInt(jsonData.get("city_id").toString());
        int chomeArea = Integer.parseInt(jsonData.get("chome_area").toString());
        int koazaArea = Integer.parseInt(jsonData.get("koaza_area").toString());
        int multiPostArea = Integer.parseInt(jsonData.get("multi_post_area").toString());
        int postId = Integer.parseInt(jsonData.get("post_id").toString());
        int oldPostId = Integer.parseInt(jsonData.get("old_post_id").toString());
        if (Common.checkKatakana(areaKana) == false || area.matches(Common.KANJI) == false) {
            throw new BadRequest("Fail validate");
        }
        areaReponsitory.updateTblArea(areaKana, area, cityId, chomeArea, koazaArea, multiPostArea, postId,
                oldPostId, areaId);
        TblAreaEntity tblAreaEntity = new TblAreaEntity(area, areaKana, multiPostArea, koazaArea, chomeArea, cityId, oldPostId, postId);
        tblAreaEntity.setAreaId(areaId);
        return tblAreaEntity;
    }

    /**
     * Delete data from tbl_area
     *
     * @param jsonData
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteTblArea(JSONObject jsonData) {
        long areaId = (long) Integer.parseInt(jsonData.get("area_id").toString());
        if (areaReponsitory.findById(areaId).isPresent() == false) {
            throw new NotFound("Delete a tbl_area Record That Not Existed");
        }
        areaReponsitory.deleteById(areaId);
    }
}
