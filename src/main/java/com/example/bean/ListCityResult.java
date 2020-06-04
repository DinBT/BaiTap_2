package com.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListCityResult {
    @JsonProperty("data")
    private List<CityByPrefecture> data;

    @JsonProperty("result")
    private String result;

    public ListCityResult(List<CityByPrefecture> data) {
        this.data = data;
        this.result = "success";
    }

    public List<CityByPrefecture> getData() {
        return data;
    }

    public void setData(List<CityByPrefecture> data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
