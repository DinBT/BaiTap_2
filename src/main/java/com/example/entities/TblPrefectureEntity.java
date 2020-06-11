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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
@Data
@Table(name = "tbl_prefecture")
public class TblPrefectureEntity {

    @Getter
    @Setter
    @Id
    @Column(name = "prefecture_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("prefecture_id")
    private long prefectureId;

    @Getter
    @Setter
    @Column(name = "prefecture", nullable = false, length = 100)
    @JsonProperty("prefecture")
    private String prefecture;

    @Getter
    @Setter
    @Column(name = "prefecture_kana", nullable = false, length = 100)
    @JsonProperty("prefecture_kana")
    private String prefectureKana;

    @Getter
    @Setter
    @Column(name = "prefecture_code", nullable = false, length = 2)
    @JsonProperty("prefecture_code")
    private String prefectureCode;

    @OneToMany(targetEntity = TblCityEntity.class, mappedBy = "tblPrefectureEntity", fetch = FetchType.LAZY)
    private List<TblCityEntity> tblCityEntityList;

    public TblPrefectureEntity(String prefecture, String prefectureKana, String prefectureCode) {
        this.prefecture = prefecture;
        this.prefectureKana = prefectureKana;
        this.prefectureCode = prefectureCode;
    }

    public TblPrefectureEntity() {
    }
}
