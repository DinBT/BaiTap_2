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
package com.example.address.reposistories;

import com.example.address.entities.TblCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.address.bean.AddressByPostCode;

/**
 * Repository interface for tbl_post
 *
 * @author DinBT
 */
@Repository
public interface SearchByPostCode extends JpaRepository<TblCityEntity, Long> {
	
	/**
	 * Search data by postCode
	 * 
	 * @param postCode
	 * @return AddressByPostCode
	 */
	@Query("SELECT new com.example.address.bean.AddressByPostCode(c.code, p.prefecture, c.city, " +
			"a.area, old.oldPostCode, post.postCode, p.prefectureKana, c.cityKana, a.areaKana, post.multiArea, " +
			"a.koazaArea, a.chomeArea, a.multiPostArea, post.updateShow, post.changeReason, p.prefectureCode) " +
			"FROM TblCityEntity c " +
			"INNER JOIN c.tblPrefectureEntity p " +
			"INNER JOIN c.tblAreaEntityList a " +
			"INNER JOIN a.tblOldPostEntity old " +
			"INNER JOIN a.tblPostEntity post " +
			"WHERE post.postCode = :postCode")
	AddressByPostCode searchByPostCode(@Param("postCode") String postCode);

}
