package com.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

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
