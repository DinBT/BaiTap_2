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

import com.example.bean.TblArea;
import com.example.bean.TblCity;
import com.example.bean.TblOldPost;
import com.example.bean.TblPost;
import com.example.bean.TblPrefecture;
import com.example.common.Common;
import com.example.exception.Faill;
import com.example.reposistories.TblAreaReponsitory;
import com.example.reposistories.TblCityReponsitory;
import com.example.reposistories.TblOldPostReponsitory;
import com.example.reposistories.TblPostReponsitory;
import com.example.reposistories.TblPrefectureReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * processing flow when edit record
 *
 * @author DinBT
 */
@Service
public class EditService {
    @Autowired
    private TblPostReponsitory postRepository;

    @Autowired
    private TblAreaReponsitory areaRepository;

    @Autowired
    private TblCityReponsitory cityRepository;

    @Autowired
    private TblPrefectureReponsitory prefectureRepository;

    @Autowired
    private TblOldPostReponsitory oldPostRepository;

    /**
     * Edit data and update to the database
     *
     * @param table    : postId to edit
     * @param jsonData : edited data
     */
    @Transactional(rollbackFor = Exception.class)
    public void editData(String table, String jsonData) {
        switch (table) {
            case "tbl_city":
                TblCity tblCity = Common.dataToTblCity(jsonData);
                cityRepository.updateTblCity(tblCity.getCode(), tblCity.getCityKana(),
                        tblCity.getCity(), tblCity.getPrefectureId(), tblCity.getCityId());
                break;
            case "tbl_area":
                TblArea tblArea = Common.dataToTblArea(jsonData);
                areaRepository.updateTblArea(tblArea.getAreaKana(), tblArea.getArea(), tblArea.getCityId(), tblArea.getChomeArea(), tblArea.getKoazaArea(), tblArea.getMultiPostArea(), tblArea.getPostId(), tblArea.getOldPostId(), tblArea.getAreaId());
                break;
            case "tbl_old_post":
                TblOldPost tblOldPost = Common.dataToTblOldPost(jsonData);
                oldPostRepository.updateTblOldPost(tblOldPost.getOldPostCode(), tblOldPost.getOldPostId());
                break;
            case "tbl_post":
                TblPost tblPost = Common.dataToTblPost(jsonData);
                postRepository.updateTblPost(tblPost.getPostCode(), tblPost.getUpdateShow(), tblPost.getChangeReason(), tblPost.getMultiArea(), tblPost.getPostId());
                break;
            case "tbl_prefecture":
                TblPrefecture tblPrefecture = Common.dataToTblPrefecture(jsonData);
                prefectureRepository.updateTblPrefecture(tblPrefecture.getPrefectureKana(), tblPrefecture.getPrefecture(), tblPrefecture.getPrefectureCode(), tblPrefecture.getPrefectureId());
                break;
            default:
                throw new Faill("edit fail!!!");
        }
    }
}
