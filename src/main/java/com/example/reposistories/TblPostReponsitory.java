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

import com.example.entities.TblPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
            "SET post_code = ?1, update_show = ?2, change_reason = ?3, multi_area = ?4 " +
            "WHERE post_id = ?5", nativeQuery = true)
    void updateTblPost(String postCode, long updateShow, long changeReason, long multiArea, long postId);


    /**
     * add data
     *
     * @param postCode     : data of post_code column
     * @param updateShow   : data of update_show column
     * @param changeReason : data of change_reason column
     * @param multiArea    : data of multi_area column
     */
    @Modifying
    @Query(value = "INSERT tbl_post " +
            "SET post_code = ?1, update_show = ?2, change_reason = ?3, multi_area = ?4 ", nativeQuery = true)
    void addTblPost(String postCode, long updateShow, long changeReason, long multiArea);

    /**
     * delete data
     *
     * @param postId : post_id about record
     */
    @Modifying
    @Query(value = "DELETE FROM tbl_post WHERE post_id = ?1", nativeQuery = true)
    void deleteTblPost(long postId);
}
