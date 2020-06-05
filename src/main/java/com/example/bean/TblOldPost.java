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
import com.sun.istack.NotNull;

import javax.persistence.Entity;

/**
 * Bean save a tbl_old_post
 *
 * @author DinBT
 */
public class TblOldPost {

    @JsonProperty("old_post_id")
    @NotNull
    private int oldPostId;

    @JsonProperty("old_post_code")
    @NotNull
    private String oldPostCode;

    public TblOldPost(int oldPostId, String oldPostCode) {
        this.oldPostId = oldPostId;
        this.oldPostCode = oldPostCode;
    }

    public int getOldPostId() {
        return oldPostId;
    }

    public void setOldPostId(int oldPostId) {
        this.oldPostId = oldPostId;
    }

    public String getOldPostCode() {
        return oldPostCode;
    }

    public void setOldPostCode(String oldPostCode) {
        this.oldPostCode = oldPostCode;
    }
}
