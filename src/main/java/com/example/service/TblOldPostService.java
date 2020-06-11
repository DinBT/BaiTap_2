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

import com.example.entities.TblOldPostEntity;
import com.example.exception.NotFound;
import com.example.reposistories.TblOldPostReponsitory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * processing flow to tbl_old_post
 *
 * @author DinBT
 */
@Service
public class TblOldPostService {
    @Autowired
    private TblOldPostReponsitory tbloldPostReponsitory;

    /**
     * Service for add new data to tbl_old_post
     *
     * @param jsonData data about tbl_old_post want add
     */
    @Transactional
    public TblOldPostEntity saveTblOldPostEntity(JSONObject jsonData) {
        TblOldPostEntity tblOldPostEntity = new TblOldPostEntity(jsonData.get("old_post_code").toString());
        tblOldPostEntity = tbloldPostReponsitory.save(tblOldPostEntity);
        return tblOldPostEntity;
    }

    /**
     * Service for edit new data into tbl_old_post
     *
     * @param jsonData data about tbl_old_post want edit
     */
    @Transactional(rollbackFor = Exception.class)
    public TblOldPostEntity updateTblOldPost(JSONObject jsonData) {
        long oldPostId = (long) Integer.parseInt(jsonData.get("old_post_id").toString());

        if (tbloldPostReponsitory.findById(oldPostId).isPresent() == false) {
            throw new NotFound("edit a tbl_old_post Record That Not Existed");
        }
        String oldPostCode = jsonData.get("old_post_code").toString();
        tbloldPostReponsitory.updateTblOldPost(oldPostCode, oldPostId);
        TblOldPostEntity tblOldPostEntity = new TblOldPostEntity(oldPostCode);
        tblOldPostEntity.setOldPostId(oldPostId);
        return tblOldPostEntity;

    }

    /**
     * Service for deleting data from tbl_old_post
     *
     * @param jsonData data about tbl_old_post want delete
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteTblOldPost(JSONObject jsonData) {
        long oldPostId = (long) Integer.parseInt(jsonData.get("old_post_id").toString());
        if (tbloldPostReponsitory.findById(oldPostId) == null) {
            throw new NotFound("Delete a tbl_old_post Record That Not Existed");
        }
        tbloldPostReponsitory.deleteById(oldPostId);
    }
}
