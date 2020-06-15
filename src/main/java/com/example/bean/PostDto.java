package com.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PostDto {
    @Getter
    @Setter
    @JsonProperty("post_id")
    @NotNull
    private int postId;

    @Getter
    @Setter
    @JsonProperty("code")
    @NotNull
    private String code;

    @Getter
    @Setter
    @JsonProperty("prefecture")
    @NotNull
    private String prefecture;

    @Getter
    @Setter
    @JsonProperty("city")
    @NotNull
    private String city;

    @Getter
    @Setter
    @JsonProperty("area")
    @NotNull
    private String area;

    @Getter
    @Setter
    @JsonProperty("old_post_code")
    @NotNull
    private String oldPostCode;

    @Getter
    @Setter
    @JsonProperty("post_code")
    @NotNull
    private String postCode;

    @Getter
    @Setter
    @JsonProperty("prefecture_kana")
    @NotNull
    private String prefectureKana;

    @Getter
    @Setter
    @JsonProperty("city_kana")
    @NotNull
    private String cityKana;

    @Getter
    @Setter
    @JsonProperty("area_kana")
    @NotNull
    private String areaKana;

    @Getter
    @Setter
    @JsonProperty("multi_area")
    @NotNull
    private int multiArea;

    @Getter
    @Setter
    @JsonProperty("koaza_area")
    @NotNull
    private int koazaArea;

    @Getter
    @Setter
    @JsonProperty("chome_area")
    @NotNull
    private int chomeArea;

    @Getter
    @Setter
    @JsonProperty("multi_post_area")
    @NotNull
    private int multiPostArea;

    @Getter
    @Setter
    @JsonProperty("update_show")
    @NotNull
    private int updateShow;

    @Getter
    @Setter
    @JsonProperty("change_reason")
    @NotNull
    private int changeReason;

    @Getter
    @Setter
    @JsonProperty("prefecture_code")
    @NotNull
    private String prefectureCode;


    public PostDto(String code, String prefecture, String city, String area, String oldPostCode,
                   String postCode, String prefectureKana, String cityKana, String areaKana,
                   int multiArea, int koazaArea, int chomeArea, int multiPostArea, int updateShow,
                   int changeReason, String prefectureCode) {
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

    public PostDto() {
    }
}
