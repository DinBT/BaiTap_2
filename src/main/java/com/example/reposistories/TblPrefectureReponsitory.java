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

import com.example.bean.CityByPrefecture;
import com.example.entities.TblPrefectureEntity;
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
public interface TblPrefectureReponsitory extends JpaRepository<TblPrefectureEntity, Long> {

    /**
     * add data
     *
     * @param prefectureKana : data of prefecture_kana column
     * @param prefecture     : data of prefecture column
     * @param prefectureCode : data of prefecture_code column
     * @param prefectureId   : data of prefecture_id column
     */
    @Modifying
    @Query(value = "UPDATE tbl_prefecture " +
            "SET prefecture_kana = ?1, " +
            "prefecture = ?2, " +
            "prefecture_code = ?3 " +
            "WHERE prefecture_id = ?4 ", nativeQuery = true)
    void updateTblPrefecture(String prefectureKana, String prefecture, String prefectureCode, long prefectureId);

    /**
     * edit data
     *
     * @param prefectureKana : data of prefecture_kana column
     * @param prefecture     : data of prefecture column
     * @param prefectureCode : data of prefecture_code column
     */
    @Modifying
    @Query(value = "INSERT tbl_prefecture " +
            "SET prefecture_kana = ?1, " +
            "prefecture = ?2, " +
            "prefecture_code = ?3 ", nativeQuery = true)
    void insertTblPrefecture(String prefectureKana, String prefecture, String prefectureCode);

    /**
     * delete data
     *
     * @param prefectureId : data of prefecture_id column
     */
    @Modifying
    @Query(value = "DELETE FROM tbl_prefecture WHERE prefecture_id = ?1 ", nativeQuery = true)
    void deleteTblPrefecture(long prefectureId);

    /**
     * Get prefecture_kana from prefectureId for checking existed record
     *
     * @param prefectureId
     * @return String : prefecture_kana
     */
    @Query(value = "SELECT prefecture_kana " +
            "FROM tbl_prefecture " +
            "WHERE prefecture_id = ?1", nativeQuery = true)
    String getPrefectureKanaById(int prefectureId);

    /**
     * Search data by prefecture
     *
     * @param prefectureCode
     * @return List<CityByPrefecture>
     */
    @Query("SELECT new com.example.bean.CityByPrefecture(c.code, p.prefecture, c.city, " +
            "p.prefectureKana, c.cityKana, p.prefectureCode) " +
            "FROM TblCityEntity c " +
            "INNER JOIN c.tblPrefectureEntity p " +
            "WHERE p.prefectureCode = ?1")
    List<CityByPrefecture> searchByPrefectureCode(String prefectureCode);
}
