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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entity for tbl_area table
 *
 * @author DinBT
 */
@Entity
@Data
@Table(name = "tbl_area")
public class TblAreaEntity {

    @Getter
    @Setter
    @Id
    @Column(name = "area_id", nullable = false)
    @JsonProperty("area_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long areaId;

    @Getter
    @Setter
    @Column(name = "area", nullable = false)
    @JsonProperty("area")
    private String area;

    @Getter
    @Setter
    @Column(name = "area_kana", nullable = false)
    @JsonProperty("area_kana")
    private String areaKana;

    @Getter
    @Setter
    @Column(name = "multi_post_area", nullable = false)
    @JsonProperty("multi_post_area")
    private int multiPostArea;

    @Getter
    @Setter
    @Column(name = "koaza_area", nullable = false)
    @JsonProperty("koaza_area")
    private int koazaArea;

    @Getter
    @Setter
    @Column(name = "chome_area", nullable = false)
    @JsonProperty("chome_area")
    private int chomeArea;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    @JsonProperty("city_id")
    private TblCityEntity tblCityEntity;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "old_post_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    @JsonProperty("old_post_id")
    private TblOldPostEntity tblOldPostEntity;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    @JsonProperty("post_id")
    private TblPostEntity tblPostEntity;

    public TblAreaEntity(String area, String areaKana, int multiPostArea, int koazaArea, int chomeArea, long tblCityEntity, long tblOldPostEntity, long tblPostEntity) {
        this.area = area;
        this.areaKana = areaKana;
        this.multiPostArea = multiPostArea;
        this.koazaArea = koazaArea;
        this.chomeArea = chomeArea;
        this.tblCityEntity = new TblCityEntity();
        this.tblOldPostEntity = new TblOldPostEntity();
        this.tblPostEntity = new TblPostEntity();
        this.tblCityEntity.setCityId(tblCityEntity);
        this.tblOldPostEntity.setOldPostId(tblOldPostEntity);
        this.tblPostEntity.setPostId(tblPostEntity);
    }


    public TblAreaEntity() {
    }
}
