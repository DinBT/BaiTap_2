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
}
