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

import com.example.entities.TblOldPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for tbl_old_post
 *
 * @author DinBT
 */
@Repository
public interface TblOldPostReponsitory extends JpaRepository<TblOldPostEntity, Long> {

    /**
     * edit data
     *
     * @param oldPostCode : data of old_post_code column
     * @param oldPostId   : data of old_post_id column
     */
    @Modifying
    @Query(value = "UPDATE tbl_old_post " +
            "SET old_post_code = ?1 " +
            "WHERE old_post_id = ?2", nativeQuery = true)
    void updateTblOldPost(String oldPostCode, long oldPostId);


    /**
     * add data
     *
     * @param oldPostCode : data of old_post_code column
     */
    @Modifying
    @Query(value = "INSERT tbl_old_post " +
            "SET old_post_code = ?1 ", nativeQuery = true)
    void insertTblOldPost(String oldPostCode);


    /**
     * delete data
     *
     * @param oldPostId :  old_post_id about record
     */
    @Modifying
    @Query(value = "DELETE FROM tbl_old_post  WHERE old_post_id = ?1", nativeQuery = true)
    void deleteTblOldPost(long oldPostId);

    /**
     * Get old_post_code by oldPostId for checking if data not existed
     *
     * @param oldPostId
     * @return String old_post_code
     */
    @Query(value = "SELECT old_post_code " +
            "FROM tbl_old_post " +
            "WHERE old_post_id = ?1", nativeQuery = true)
    String getOldPostCodeById(int oldPostId);
}
