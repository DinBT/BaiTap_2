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

import com.example.exception.NotFound;
import com.example.reposistories.TblOldPostReponsitory;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
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
    private TblOldPostReponsitory oldPostReponsitory;

    /**
     * Service for add new data into tbl_old_post
     *
     * @param jsonData
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertTblOldPost(String jsonData) {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonData);
        String oldPostCode = jsonObject.get("old_post_code").toString();
        oldPostReponsitory.insertTblOldPost(oldPostCode);
    }

    /**
     * Service for edit new data into tbl_old_post
     *
     * @param jsonData
     * @param oldPostId
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateTblOldPost(String jsonData, int oldPostId) {
        if (oldPostReponsitory.getOldPostCodeById(oldPostId) == null) {
            throw new NotFound("edit a tbl_old_post Record That Not Existed");
        }
        JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonData);
        String oldPostCode = jsonObject.get("old_post_code").toString();
        oldPostReponsitory.updateTblOldPost(oldPostCode, oldPostId);
    }

    /**
     * Service for deleting data from tbl_old_post
     *
     * @param oldPostId
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteTblOldPost(int oldPostId) {
        if (oldPostReponsitory.getOldPostCodeById(oldPostId) == null) {
            throw new NotFound("Delete a tbl_old_post Record That Not Existed");
        }
        oldPostReponsitory.deleteTblOldPost(oldPostId);
    }

}
