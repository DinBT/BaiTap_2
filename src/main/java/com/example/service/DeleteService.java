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
 * processing flow when delete record
 *
 * @author DinBT
 */
@Service
public class DeleteService {
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
     * delete data and update to the database by Id
     *
     * @param table    : postId to edit
     * @param id : edited data
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteData(String table, String id) {
        switch (table) {
            case "tbl_city":
                cityRepository.deleteTblCity(Integer.parseInt(id));
                break;
            case "tbl_area":
                areaRepository.deleteTblArea(Integer.parseInt(id));
                break;
            case "tbl_old_post":
                oldPostRepository.deleteTblOldPost(Integer.parseInt(id));
                break;
            case "tbl_post":
                postRepository.deleteTblPost(Integer.parseInt(id));
                break;
            case "tbl_prefecture":
                prefectureRepository.deleteTblPrefecture(Integer.parseInt(id));
                break;
            default:
                throw new Faill("delete fail!!!");
        }
    }
}