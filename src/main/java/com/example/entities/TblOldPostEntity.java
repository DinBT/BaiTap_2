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
 * Entity for tbl_old_post table
 *
 * @author DinBT
 */
@Entity
@Table(name = "tbl_old_post")
public class TblOldPostEntity {
	
	@Id
	@Column(name = "old_post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "old_post_code")
	private String oldPostCode;
	
	@OneToMany(targetEntity = TblAreaEntity.class, mappedBy = "id", fetch = FetchType.LAZY)
	private List<TblAreaEntity> tblAreaEntityList;
	
	
	public String getOldPostCode() {
		return oldPostCode;
	}

	public void setOldPostCode(String oldPostCode) {
		this.oldPostCode = oldPostCode;
	}

	public List<TblAreaEntity> getTblAreaEntityList() {
		return tblAreaEntityList;
	}

	public void setTblAreaEntityList(List<TblAreaEntity> tblAreaEntityList) {
		this.tblAreaEntityList = tblAreaEntityList;
	}

}
