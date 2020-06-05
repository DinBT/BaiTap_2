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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entity for tbl_city table
 *
 * @author DinBT
 */
@Entity
@Table(name = "tbl_city")
public class TblCityEntity {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "city_kana")
    private String cityKana;

    @Column(name = "code")
    private String code;

    @Column(name = "city")
    private String city;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prefecture_id")
    @Fetch(FetchMode.JOIN)
    private TblPrefectureEntity tblPrefectureEntity;


    @OneToMany(targetEntity = TblAreaEntity.class, mappedBy = "id", fetch = FetchType.LAZY)
    private List<TblAreaEntity> tblAreaEntityList;

//    public TblCityEntity(String code, String cityKana, String city, long pr_id) {
//        this.code = code;
//        this.city = city;
//        this.cityKana = cityKana;
//        this.pr_id = pr_id;
//    }
//
//    public TblCityEntity(long id, String code, String cityKana, String city, long pr_id) {
//        this.id = id;
//        this.code = code;
//        this.city = city;
//        this.cityKana = cityKana;
//        this.pr_id = pr_id;
//    }
//
//    public long getPr_id() {
//        return pr_id;
//    }
//
//    public void setPr_id(long pr_id) {
//        this.pr_id = pr_id;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityKana() {
        return cityKana;
    }

    public void setCityKana(String cityKana) {
        this.cityKana = cityKana;
    }

    public TblPrefectureEntity getTblPrefectureEntity() {
        return tblPrefectureEntity;
    }

    public void setTblPrefectureEntity(TblPrefectureEntity tblPrefectureEntity) {
        this.tblPrefectureEntity = tblPrefectureEntity;
    }

    public List<TblAreaEntity> getTblAreaEntityList() {
        return tblAreaEntityList;
    }

    public void setTblAreaEntityList(List<TblAreaEntity> tblAreaEntityList) {
        this.tblAreaEntityList = tblAreaEntityList;
    }

}