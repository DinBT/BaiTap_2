package com.example.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressByCode {
    @JsonProperty("code")
    private String code;

    @JsonProperty("prefecture")
    private String prefecture;

    @JsonProperty("city")
    private String city;

    @JsonProperty("area")
    private String area;

    @JsonProperty("old_post_code")
    private String oldPostCode;

    @JsonProperty("post_code")
    private String postCode;

    @JsonProperty("prefecture_kana")
    private String prefectureKana;

    @JsonProperty("city_kana")
    private String cityKana;

    @JsonProperty("area_kana")
    private String areaKana;

    @JsonProperty("multi_area")
    private int multiArea;

    @JsonProperty("koaza_area")
    private int koazaArea;

    @JsonProperty("chome_area")
    private int chomeArea;

    @JsonProperty("multi_post_area")
    private int multiPostArea;

    @JsonProperty("update_show")
    private int updateShow;

    @JsonProperty("change_reason")
    private int changeReason;

    @JsonProperty("prefecture_code")
    private String prefectureCode;

    public AddressByCode(String code, String prefecture, String city, String area, String oldPostCode, String postCode, String prefectureKana, String cityKana, String areaKana, int multiArea, int koazaArea, int chomeArea, int multiPostArea, int updateShow, int changeReason, String prefectureCode) {
        this.code = code;
        this.prefecture = prefecture;
        this.city = city;
        this.area = area;
        this.oldPostCode = oldPostCode;
        this.postCode = postCode;
        this.prefectureKana = prefectureKana;
        this.cityKana = cityKana;
        this.areaKana = areaKana;
        this.multiArea = multiArea;
        this.koazaArea = koazaArea;
        this.chomeArea = chomeArea;
        this.multiPostArea = multiPostArea;
        this.updateShow = updateShow;
        this.changeReason = changeReason;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOldPostCode() {
        return oldPostCode;
    }

    public void setOldPostCode(String oldPostCode) {
        this.oldPostCode = oldPostCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
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

    public String getAreaKana() {
        return areaKana;
    }

    public void setAreaKana(String areaKana) {
        this.areaKana = areaKana;
    }

    public int getMultiArea() {
        return multiArea;
    }

    public void setMultiArea(int multiArea) {
        this.multiArea = multiArea;
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

    public int getMultiPostArea() {
        return multiPostArea;
    }

    public void setMultiPostArea(int multiPostArea) {
        this.multiPostArea = multiPostArea;
    }

    public int getUpdateShow() {
        return updateShow;
    }

    public void setUpdateShow(int updateShow) {
        this.updateShow = updateShow;
    }

    public int getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(int changeReason) {
        this.changeReason = changeReason;
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
                "\",\"old_post_code\":\"" + oldPostCode +
                "\",\"post_code\":\"" + postCode +
                "\",\"prefecture_kana\":\"" + prefectureKana +
                "\",\"city_kana\":\"" + cityKana +
                "\",\"area_kana\":\"" + areaKana +
                "\",\"prefecture\":\"" + prefecture +
                "\",\"city\":\"" + city +
                "\",\"area\":\"" + area +
                "\",\"multi_area\":" + multiArea +
                ",\"koaza_area\":" + koazaArea +
                ",\"chome_area\":" + chomeArea +
                ",\"multi_post_area\":" + multiPostArea +
                ",\"update_show\":" + updateShow +
                ",\"change_reason\":" + changeReason +
                ",\"prefecture_code\":\"" + prefectureCode + "\"}";
    }
}

