package com.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class TblPrefecture {
    @JsonProperty("prefecture_id")
    @NotNull
    private int prefectureId;

    @JsonProperty("prefecture_kana")
    @NotNull
    private String prefectureKana;

    @JsonProperty("prefecture")
    @NotNull
    private String prefecture;

    @JsonProperty("prefecture_code")
    @NotNull
    private String prefectureCode;

    public TblPrefecture(int prefectureId, String prefectureKana, String prefecture, String prefectureCode) {
        this.prefectureId = prefectureId;
        this.prefectureKana = prefectureKana;
        this.prefecture = prefecture;
        this.prefectureCode = prefectureCode;
    }

    public int getPrefectureId() {
        return prefectureId;
    }

    public void setPrefectureId(int prefectureId) {
        this.prefectureId = prefectureId;
    }

    public String getPrefectureKana() {
        return prefectureKana;
    }

    public void setPrefectureKana(String prefectureKana) {
        this.prefectureKana = prefectureKana;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getPrefectureCode() {
        return prefectureCode;
    }

    public void setPrefectureCode(String prefectureCode) {
        this.prefectureCode = prefectureCode;
    }
}
