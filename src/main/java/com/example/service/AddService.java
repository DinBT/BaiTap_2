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
 * processing flow when add record
 *
 * @author DinBT
 */
@Service
public class AddService {
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
     * add data and update to the database
     *
     * @param table    : postId to edit
     * @param jsonData : edited data
     */
    @Transactional(rollbackFor = Exception.class)
    public void addData(String table, String jsonData) {
        switch (table) {
            case "tbl_city":
                TblCity tblCity = Common.dataToTblCity(jsonData);
                cityRepository.addTblCity(tblCity.getCode(), tblCity.getCityKana(),
                        tblCity.getCity(), tblCity.getPrefectureId());
                break;
            case "tbl_area":
                TblArea tblArea = Common.dataToTblArea(jsonData);
                areaRepository.addTblArea(tblArea.getAreaKana(), tblArea.getArea(), tblArea.getCityId(), tblArea.getChomeArea(), tblArea.getKoazaArea(), tblArea.getMultiPostArea(), tblArea.getPostId(), tblArea.getOldPostId());
                break;
            case "tbl_old_post":
                TblOldPost tblOldPost = Common.dataToTblOldPost(jsonData);
                oldPostRepository.addTblOldPost(tblOldPost.getOldPostCode());
                break;
            case "tbl_post":
                TblPost tblPost = Common.dataToTblPost(jsonData);
                postRepository.addTblPost(tblPost.getPostCode(), tblPost.getUpdateShow(), tblPost.getChangeReason(), tblPost.getMultiArea());
                break;
            case "tbl_prefecture":
                TblPrefecture tblPrefecture = Common.dataToTblPrefecture(jsonData);
                prefectureRepository.addTblPrefecture(tblPrefecture.getPrefectureKana(), tblPrefecture.getPrefecture(), tblPrefecture.getPrefectureCode());
                break;
            default:
                throw new Faill("add fail!!!");
        }
    }
}
