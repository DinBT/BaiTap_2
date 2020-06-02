package com.example.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityByPostCode {
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

    public CityByPostCode(String code, String prefecture, String city, String prefectureKana, String cityKana, String prefectureCode) {
        this.code = code;
        this.prefecture = prefecture;
        this.city = city;
        this.prefectureKana = prefectureKana;
        this.cityKana = cityKana;
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
