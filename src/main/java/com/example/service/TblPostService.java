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
import com.example.bean.PostDto;
import com.example.common.Common;
import com.example.entities.TblPostEntity;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.reposistories.TblPostReponsitory;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
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
     * Service for delete record to tbl_post
     * <p>
     * //     * @param jsonData data about TblPostEntity want delete
     */
    @Transactional(rollbackFor = Exception.class)
    public void delete(long postId) {
//        long postId = (long) Integer.parseInt(jsonData.get("post_id").toString());
        if (postReponsitory.findById(postId).isPresent() == false) {
            throw new NotFound("delete a tbl_post Record That Not Existed");
        }
        postReponsitory.deleteById(postId);
    }

    /**
     * Service for add new data to tbl_post
     *
     * @param jsonData data about TblPostEntity want add
     * @return TblPostEntity
     */
    @Transactional(rollbackFor = Exception.class)
    public TblPostEntity saveTblPost(PostDto jsonData) {
        String postCode = jsonData.getPostCode();
        int updateShow = jsonData.getUpdateShow();
        int changeReason = jsonData.getChangeReason();
        int multiArea = jsonData.getMultiArea();
        TblPostEntity tblPostEntity = new TblPostEntity(postCode, multiArea, updateShow, changeReason);
        if (!postCode.matches(Common.POST_CODE)) {
            throw new BadRequest("Fail validate");
        }
        tblPostEntity = postReponsitory.save(tblPostEntity);
        return tblPostEntity;
    }

    /**
     * Service for edit new data into tbl_post
     *
     * @param jsonData data about TblPostEntity want edit
     */
    @Transactional(rollbackFor = Exception.class)
    public TblPostEntity updateTblPost(JSONObject jsonData) {
        long postId = (long) Integer.parseInt(jsonData.get("post_id").toString());
        if (postReponsitory.findById(postId).isPresent() != false) {
            String postCode = jsonData.get("post_code").toString();
            int updateShow = Integer.parseInt(jsonData.get("update_show").toString());
            int changeReason = Integer.parseInt(jsonData.get("change_reason").toString());
            int multiArea = Integer.parseInt(jsonData.get("multi_area").toString());
            if (!postCode.matches(Common.POST_CODE)) {
                throw new BadRequest("Fail validate");
            }
            postReponsitory.updateTblPost(postCode, updateShow, changeReason, multiArea, postId);
            TblPostEntity tblPostEntity = new TblPostEntity(postCode, updateShow, changeReason, multiArea);
            tblPostEntity.setPostId(postId);
            return tblPostEntity;
        } else {
            throw new NotFound("Update a tbl_post Record That Not Existed");
        }
    }

    /**
     * Service for seaching by postCode
     *
     * @param postCode data of post_code column
     * @return List<AddressByPostCode>: Address had search
     */
    public List<AddressByPostCode> searchByPostCode(String postCode) {
        return postReponsitory.searchByPostCode(postCode);
    }

}
