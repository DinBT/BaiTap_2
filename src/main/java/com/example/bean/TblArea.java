package com.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class TblArea {
    @JsonProperty("area_id")
    @NotNull
    private int areaId;

    @JsonProperty("area_kana")
    @NotNull
    private String areaKana;

    @JsonProperty("area")
    @NotNull
    private String area;

    @JsonProperty("city_id")
    @NotNull
    private int cityId;

    @JsonProperty("chome_area")
    @NotNull
    private int chomeArea;

    @JsonProperty("koaza_area")
    @NotNull
    private int koazaArea;

    @JsonProperty("muilti_post_area")
    @NotNull
    private int multiPostArea;

    @JsonProperty("post_id")
    @NotNull
    private int postId;

    @JsonProperty("old_post_id")
    @NotNull
    private int oldPostId;

    public TblArea(int areaId, String areaKana, String area, int cityId, int chomeArea, int koazaArea, int multiPostArea, int postId, int oldPostId) {
        this.areaId = areaId;
        this.areaKana = areaKana;
        this.area = area;
        this.cityId = cityId;
        this.chomeArea = chomeArea;
        this.koazaArea = koazaArea;
        this.multiPostArea = multiPostArea;
        this.postId = postId;
        this.oldPostId = oldPostId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaKana() {
        return areaKana;
    }

    public void setAreaKana(String areaKana) {
        this.areaKana = areaKana;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getChomeArea() {
        return chomeArea;
    }

    public void setChomeArea(int chomeArea) {
        this.chomeArea = chomeArea;
    }

    public int getKoazaArea() {
        return koazaArea;
    }

    public void setKoazaArea(int koazaArea) {
        this.koazaArea = koazaArea;
    }

    public int getMultiPostArea() {
        return multiPostArea;
    }

    public void setMultiPostArea(int multiPostArea) {
        this.multiPostArea = multiPostArea;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getOldPostId() {
        return oldPostId;
    }

    public void setOldPostId(int oldPostId) {
        this.oldPostId = oldPostId;
    }
}
