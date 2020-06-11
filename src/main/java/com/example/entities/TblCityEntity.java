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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entity for tbl_city table
 *
 * @author DinBT
 */
@Entity
@Data
@Table(name = "tbl_city")
public class TblCityEntity {

    @Getter
    @Setter
    @Id
    @Column(name = "city_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("city_id")
    private long cityId;

    @Getter
    @Setter
    @Column(name = "city_kana", nullable = false, length = 5)
    @JsonProperty("city_kana")
    private String cityKana;

    @Getter
    @Setter
    @Column(name = "code",nullable = false, length = 100)
    @JsonProperty("code")
    private String code;

    @Getter
    @Setter
    @Column(name = "city", nullable = false,length = 100)
    @JsonProperty("city")
    private String city;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prefecture_id",nullable = false)
    @Fetch(FetchMode.JOIN)
    @JsonProperty("prefecture_id")
    private TblPrefectureEntity tblPrefectureEntity;

    @OneToMany(targetEntity = TblAreaEntity.class, mappedBy = "tblCityEntity", fetch = FetchType.LAZY)
    private List<TblAreaEntity> tblAreaEntityList;

    public TblCityEntity(String cityKana, String code, String city, long tblPrefectureEntity) {
        this.cityKana = cityKana;
        this.code = code;
        this.city = city;
        this.tblPrefectureEntity = new TblPrefectureEntity();
        this.tblPrefectureEntity.setPrefectureId(tblPrefectureEntity);
    }

    public TblCityEntity() {
    }
}
