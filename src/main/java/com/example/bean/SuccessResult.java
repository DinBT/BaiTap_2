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
 * Data Tranfer Object for success
 *
 * @author DinBT
 */
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
