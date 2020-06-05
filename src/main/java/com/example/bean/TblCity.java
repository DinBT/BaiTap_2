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
package com.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

/**
 * Bean save a tbl_city
 *
 * @author DinBT
 */
public class TblCity {
    @JsonProperty("city_id")
    @NotNull
    private long cityId;

    @JsonProperty("code")
    @NotNull
    private String code;

    @JsonProperty("city_kana")
    @NotNull
    private String cityKana;

    @JsonProperty("city")
    @NotNull
    private String city;

    @JsonProperty("prefecture_id")
    @NotNull
    private long prefectureId;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getCityId() {
        return cityId;
    }

    public long getPrefectureId() {
        return prefectureId;
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

    public TblCity(long cityId, String code, String cityKana, String city, long prefectureId) {
        this.cityId = cityId;
        this.code = code;
        this.cityKana = cityKana;
        this.city = city;
        this.prefectureId = prefectureId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public void setPrefectureId(long prefectureId) {
        this.prefectureId = prefectureId;
    }
}
