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

import com.example.bean.AddressByPostCode;
import com.example.bean.ErrorResult;
import com.example.common.Common;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.reposistories.TblPostReponsitory;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * processing flow to tbl_post
 *
 * @author DinBT
 */
@Service
public class TblPostService {
    @Autowired
    private TblPostReponsitory postReponsitory;


    /**
     * Service for add new data to tbl_post
     *
     * @param jsonData
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertTblPost(JSONObject jsonData) {
        String postCode = jsonData.get("post_code").toString();
        int updateShow = Integer.parseInt(jsonData.get("update_show").toString());
        int changeReason = Integer.parseInt(jsonData.get("change_reason").toString());
        int multiArea = Integer.parseInt(jsonData.get("multi_area").toString());
        if (!postCode.matches(Common.POST_CODE)) {
            throw new BadRequest("Validate Not Passed");
        }
        postReponsitory.insertTblPost(postCode, updateShow, changeReason, multiArea);
    }

    /**
     * Service for edit new data into tbl_post
     *
     * @param jsonData
     * @param postId
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateTblPost(JSONObject jsonData, int postId) {
        if (postReponsitory.getPostCodeById(postId) == null) {
            throw new NotFound("Update a tbl_post Record That Not Existed");
        }
        String postCode = jsonData.get("post_code").toString();
        int updateShow = Integer.parseInt(jsonData.get("update_show").toString());
        int changeReason = Integer.parseInt(jsonData.get("change_reason").toString());
        int multiArea = Integer.parseInt(jsonData.get("multi_area").toString());
        if (!postCode.matches(Common.POST_CODE)) {
            throw new BadRequest("Validate Not Passed");
        }
        postReponsitory.updateTblPost(postCode, updateShow, changeReason, multiArea, postId);
    }

    /**
     * Service for deleting data from tbl_post
     *
     * @param postId
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteTblPost(int postId) {
        if (postReponsitory.getPostCodeById(postId) == null) {
            throw new NotFound("Delete a tbl_post Record That Not Existed");
        }
        postReponsitory.deleteTblPost(postId);
    }

    /**
     * Service for seaching by postCode
     *
     * @param postCode
     * @return List<AddressByPostCode>: Address had search
     */
    public List<AddressByPostCode> searchByPostCode(String postCode) {
        return postReponsitory.searchByPostCode(postCode);
    }

}
