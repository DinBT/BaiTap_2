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
import com.example.entities.TblCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bean.AddressByPostCode;

import java.util.List;

/**
 * Repository interface for tbl_post
 *
 * @author DinBT
 */
@Repository
public interface TblCityReponsitory extends JpaRepository<TblCityEntity, Long> {

    /**
     * Search data by postCode
     *
     * @param postCode
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
            "WHERE post.postCode = :postCode")
    List<AddressByPostCode> searchByPostCode(@Param("postCode") String postCode);


    /**
     * Search data by postCode
     *
     * @param prefectureCode
     * @return List<CityByPrefecture>
     */
    @Query("SELECT new com.example.bean.CityByPrefecture(c.code, p.prefecture, c.city, " +
            "p.prefectureKana, c.cityKana, p.prefectureCode) " +
            "FROM TblCityEntity c " +
            "INNER JOIN c.tblPrefectureEntity p " +
            "WHERE p.prefectureCode = :prefectureCode")
    List<CityByPrefecture> searchByPrefectureCode(@Param("prefectureCode") String prefectureCode);

    @Modifying
    @Query(value = "UPDATE tbl_city " +
            "SET code = ?1, city_kana = ?2, city = ?3, prefecture_id = ?4 " +
            "WHERE city_id = ?5", nativeQuery = true)
    void updateTblCity(String code, String cityKana, String city, long pr_id, long cityId);

    @Modifying
    @Query(value = "INSERT tbl_city " +
            "SET code = ?1, city_kana = ?2, city = ?3, prefecture_id = ?4 ", nativeQuery = true)
    void addTblCity(String code, String cityKana, String city, long pr_id);

    @Modifying
    @Query(value = "DELETE FROM tbl_city WHERE city_id = ?1", nativeQuery = true)
    void deleteTblCity(long cityId);
}
