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
package com.example.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity for tbl_prefecture table
 *
 * @author DinBT
 */
@Entity
@Table(name = "tbl_prefecture")
public class TblPrefectureEntity {
	
	@Id
	@Column(name = "prefecture_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "prefecture")
	private String prefecture;
	
	@Column(name = "prefecture_kana")
	private String prefectureKana;
	
	@Column(name = "prefecture_code")
	private String prefectureCode;
	
	@OneToMany(targetEntity = TblCityEntity.class, mappedBy = "id", fetch = FetchType.LAZY)
	private List<TblCityEntity> tblCityEntityList;

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getPrefectureKana() {
		return prefectureKana;
	}

	public void setPrefectureKana(String prefectureKana) {
		this.prefectureKana = prefectureKana;
	}

	public String getPrefectureCode() {
		return prefectureCode;
	}

	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public List<TblCityEntity> getTblCityEntityList() {
		return tblCityEntityList;
	}

	public void setTblCityEntityList(List<TblCityEntity> tblCityEntityList) {
		this.tblCityEntityList = tblCityEntityList;
	}

}
