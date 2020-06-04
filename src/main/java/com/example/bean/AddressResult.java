package com.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AddressResult {
    @JsonProperty("data")
    private List<AddressByPostCode> data;

    @JsonProperty("result")
    private String result;

    public AddressResult(List<AddressByPostCode> data) {
        this.data = data;
        this.result = "success";
    }

    public List<AddressByPostCode> getData() {
        return data;
    }

    public void setData(List<AddressByPostCode> data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
