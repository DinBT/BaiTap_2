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

/**
 * Bean save results searching by prefectureCode
 *
 * @author DinBT
 */
public class CityByPrefecture {

    @JsonProperty("code")
    private String code;

    @JsonProperty("prefecture")
    private String prefecture;

    @JsonProperty("city")
    private String city;

    @JsonProperty("prefecture_kana")
    private String prefectureKana;

    @JsonProperty("city_kana")
    private String cityKana;

    @JsonProperty("prefecture_code")
    private String prefectureCode;

    public CityByPrefecture() {

    }

    public CityByPrefecture(String code, String prefecture, String city,
                            String prefectureKana, String cityKana, String prefectureCode) {
        this.code = code;
        this.prefecture = prefecture;
        this.city = city;
        this.prefectureKana = prefectureKana;
        this.cityKana = cityKana;
        this.prefectureCode = prefectureCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrefectureKana() {
        return prefectureKana;
    }

    public void setPrefectureKana(String prefectureKana) {
        this.prefectureKana = prefectureKana;
    }

    public String getCityKana() {
        return cityKana;
    }

    public void setCityKana(String cityKana) {
        this.cityKana = cityKana;
    }

    public String getPrefectureCode() {
        return prefectureCode;
    }

    public void setPrefectureCode(String prefectureCode) {
        this.prefectureCode = prefectureCode;
    }

    @Override
    public String toString() {
        return "{code\":" + code +
                "\",\"prefecture\":\"" + prefecture +
                "\",\"city\":\"" + city +
                "\",\"prefecture_kana\":\"" + prefectureKana +
                "\",\"city_kana\":\"" + cityKana +
                ",\"prefecture_code\":\"" + prefectureCode + "}\"";

    }
}
