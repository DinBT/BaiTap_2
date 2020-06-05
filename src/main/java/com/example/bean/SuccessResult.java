package com.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessResult {
    @JsonProperty("success")
    private String success;

    @JsonProperty("success_description")
    private String successDescription;

    public SuccessResult(String success, String successDescription) {
        this.success = success;
        this.successDescription = successDescription;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getSuccessDescription() {
        return successDescription;
    }

    public void setSuccessDescription(String successDescription) {
        this.successDescription = successDescription;
    }
}
