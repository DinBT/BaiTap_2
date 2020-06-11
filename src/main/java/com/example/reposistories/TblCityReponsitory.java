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

import com.example.entities.TblCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Repository interface for tbl_city
 *
 * @author DinBT
 */
@Repository
public interface TblCityReponsitory extends JpaRepository<TblCityEntity, Long> {

    /**
     * edit data
     *
     * @param code     : data of code column
     * @param cityKana : data of city_kana column
     * @param city     : data of city column
     * @param pr_id    : data of prefecture column
     * @param cityId   : data of city_id
     */
    @Modifying
    @Query(value = "UPDATE tbl_city " +
            "SET code = ?1, " +
            "city_kana = ?2, " +
            "city = ?3, " +
            "prefecture_id = ?4 " +
            "WHERE city_id = ?5", nativeQuery = true)
    void updateTblCity(String code, String cityKana, String city, long pr_id, long cityId);
}
