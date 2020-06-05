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
 * Data Transfer Object for error
 *
 * @author DinBT
 */
public class ErrorResult {
    @JsonProperty("error")
    private String error;

    @JsonProperty("error_description")
    private String errorDescription;


    public ErrorResult(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
