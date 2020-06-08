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

import java.util.List;

/**
 * Bean save results searching by prefectureCode to view
 *
 * @author DinBT
 */
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
