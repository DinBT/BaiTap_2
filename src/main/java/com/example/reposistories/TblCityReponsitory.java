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

    /**
     * add data
     *
     * @param code         : data of code column
     * @param cityKana     : data of city_kana column
     * @param city         : data of city column
     * @param prefectureId : data of prefecture column
     */
    @Modifying
    @Query(value = "INSERT INTO tbl_city(code, city_kana, city, prefecture_id) " +
            "VALUES (:code, :cityKana, :city, :prefectureId)", nativeQuery = true)
    void insertTblCity(@Param("code") String code,
                       @Param("cityKana") String cityKana,
                       @Param("city") String city,
                       @Param("prefectureId") int prefectureId);

    /**
     * delete data
     *
     * @param cityId : city_id about record
     */
    @Modifying
    @Query(value = "DELETE FROM tbl_city WHERE city_id = ?1", nativeQuery = true)
    void deleteTblCity(long cityId);

    /**
     * Get code from cityId for checking existed data
     *
     * @param cityId
     * @return String: code
     */
    @Query(value = "SELECT code " +
            "FROM tbl_city " +
            "WHERE city_id = ?1", nativeQuery = true)
    String getCodeById(long cityId);
}
