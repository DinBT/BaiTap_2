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

import com.example.entities.TblAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for tbl_area
 *
 * @author DinBT
 */
@Repository
public interface TblAreaReponsitory extends JpaRepository<TblAreaEntity, Long> {

    /**
     * edit data
     *
     * @param areaKana      : data of area_kana column
     * @param area          : data of area column
     * @param cityId        : data of city_id column
     * @param chomeArea     : data of chome_area column
     * @param koazaArea     : data of koaza_area column
     * @param multiPostArea : data of multi_post_area column
     * @param postId        : data of post_id column
     * @param oldPostId     : data of old_post_id column
     * @param areaId        : data of area_id
     */
    @Modifying
    @Query(value = "UPDATE tbl_area " +
            "SET area_kana = ?1, " +
            "area = ?2, " +
            "city_id = ?3, " +
            "chome_area = ?4, " +
            "koaza_area = ?5," +
            " multi_post_area = ?6," +
            " post_id = ?7, " +
            "old_post_id = ?8 " +
            "WHERE area_id = ?9", nativeQuery = true)
    void updateTblArea(String areaKana, String area, long cityId, long chomeArea, long koazaArea, long multiPostArea, long postId, long oldPostId, long areaId);

    /**
     * Insert new data into tbl_area
     *
     * @param areaKana      : data of area_kana column
     * @param area          : data of area column
     * @param cityId        : data of city_id column
     * @param chomeArea     : data of chome_area column
     * @param koazaArea     : data of koaza_area column
     * @param multiPostArea : data of multi_post_area column
     * @param postId        : data of post_id column
     * @param oldPostId     : data of old_post_id column
     */
    @Modifying
    @Query(value = "INSERT INTO tbl_area(area_kana, area, city_id, chome_area, koaza_area, multi_post_area, post_id, old_post_id) " +
            "VALUES(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void insertTblArea(String areaKana, String area, long cityId, long chomeArea, long koazaArea, long multiPostArea, long postId, long oldPostId);

    /**
     * delete data
     *
     * @param areaId : area_id about record
     */
    @Modifying
    @Query(value = "DELETE FROM tbl_area WHERE area_id = ?1", nativeQuery = true)
    void deleteFromTblArea(long areaId);

    /**
     * Select area_id for checking existed data when inserting new data
     *
     * @param areaKana      : data of area_kana column
     * @param area          : data of area column
     * @param cityId        : data of city_id column
     * @param chomeArea     : data of chome_area column
     * @param koazaArea     : data of koaza_area column
     * @param multiPostArea : data of multi_post_area column
     * @param postId        : data of post_id column
     * @param oldPostId     : data of old_post_id column
     * @return Integer : area_id
     */
    @Query(value = "SELECT area_id " +
            "FROM tbl_area " +
            "WHERE area_kana = ?1 " +
            "AND area = ?2 " +
            "AND city_id = ?3 " +
            "AND chome_area = ?4 " +
            "AND koaza_area = ?5 " +
            "AND multi_post_area = ?6 " +
            "AND post_id = ?7 " +
            "AND old_post_id = ?8", nativeQuery = true)
    Integer getAreaById(String areaKana, String area, int cityId, int chomeArea, int koazaArea,
                        int multiPostArea, int postId, int oldPostId);

    /**
     * Get area_kana by area_id
     *
     * @param areaId
     * @return String: area_kana
     */
    @Query(value = "SELECT area_kana " +
            "FROM tbl_area " +
            "WHERE area_id = ?1", nativeQuery = true)
    String getAreaKanaById(int areaId);

}
