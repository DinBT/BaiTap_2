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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entity for tbl_area table
 *
 * @author DinBT
 */
@Entity
@Table(name = "tbl_area")
public class TblAreaEntity {

    @Id
    @Column(name = "area_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "area")
    private String area;

    @Column(name = "area_kana")
    private String areaKana;

    @Column(name = "multi_post_area")
    private int multiPostArea;

    @Column(name = "koaza_area")
    private int koazaArea;

    @Column(name = "chome_area")
    private int chomeArea;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private TblCityEntity tblCityEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "old_post_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private TblOldPostEntity tblOldPostEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private TblPostEntity tblPostEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaKana() {
        return areaKana;
    }

    public void setAreaKana(String areaKana) {
        this.areaKana = areaKana;
    }

    public int getMultiPostArea() {
        return multiPostArea;
    }

    public void setMultiPostArea(int multiPostArea) {
        this.multiPostArea = multiPostArea;
    }

    public int getKoazaArea() {
        return koazaArea;
    }

    public void setKoazaArea(int koazaArea) {
        this.koazaArea = koazaArea;
    }

    public int getChomeArea() {
        return chomeArea;
    }

    public void setChomeArea(int chomeArea) {
        this.chomeArea = chomeArea;
    }

    public TblCityEntity getTblCityEntity() {
        return tblCityEntity;
    }

    public void setTblCityEntity(TblCityEntity tblCityEntity) {
        this.tblCityEntity = tblCityEntity;
    }

    public TblOldPostEntity getTblOldPostEntity() {
        return tblOldPostEntity;
    }

    public void setTblOldPostEntity(TblOldPostEntity tblOldPostEntity) {
        this.tblOldPostEntity = tblOldPostEntity;
    }

    public TblPostEntity getTblPostEntity() {
        return tblPostEntity;
    }

    public void setTblPostEntity(TblPostEntity tblPostEntity) {
        this.tblPostEntity = tblPostEntity;
    }

}
