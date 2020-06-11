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
package com.example.reposistories;

import com.example.bean.AddressByPostCode;
import com.example.entities.TblPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for tbl_post
 *
 * @author DinBT
 */
@Repository
public interface TblPostReponsitory extends JpaRepository<TblPostEntity, Long> {

    /**
     * edit data
     *
     * @param postCode     : data of post_code column
     * @param updateShow   : data of update_show column
     * @param changeReason : data of change_reason column
     * @param multiArea    : data of multi_area column
     * @param postId       : data of post_id column
     */
    @Modifying
    @Query(value = "UPDATE tbl_post " +
            "SET post_code = ?1, " +
            "update_show = ?2, " +
            "change_reason = ?3, " +
            "multi_area = ?4 " +
            "WHERE post_id = ?5", nativeQuery = true)
    void updateTblPost(String postCode, int updateShow, int changeReason, int multiArea, long postId);


    /**
     * Search data by postCode
     *
     * @param postCode data of post_code column
     * @return List<AddressByPostCode>
     */
    @Query("SELECT new com.example.bean.AddressByPostCode(c.code, p.prefecture, c.city, " +
            "a.area, old.oldPostCode, post.postCode, p.prefectureKana, c.cityKana, a.areaKana, post.multiArea, " +
            "a.koazaArea, a.chomeArea, a.multiPostArea, post.updateShow, post.changeReason, p.prefectureCode) " +
            "FROM TblCityEntity c " +
            "INNER JOIN c.tblPrefectureEntity p " +
            "INNER JOIN c.tblAreaEntityList a " +
            "INNER JOIN a.tblOldPostEntity old " +
            "INNER JOIN a.tblPostEntity post " +
            "WHERE post.postCode = ?1")
    List<AddressByPostCode> searchByPostCode(String postCode);
}
