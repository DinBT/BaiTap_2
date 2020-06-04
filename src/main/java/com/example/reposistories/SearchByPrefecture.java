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

import java.util.List;

import com.example.entities.TblCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bean.CityByPrefecture;

/**
 * Repository interface for tbl_prefecture
 *
 * @author DinBT
 */
@Repository
public interface SearchByPrefecture extends JpaRepository<TblCityEntity, Long> {
	
	/**
	 * Search data by prefectureCode
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

}
