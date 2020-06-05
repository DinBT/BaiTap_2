package com.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class TblPost {
    @JsonProperty("post_id")
    @NotNull
    private int postId;

    @JsonProperty("post_code")
    @NotNull
    private String postCode;

    @JsonProperty("update_show")
    @NotNull
    private int updateShow;

    @JsonProperty("change_reason")
    @NotNull
    private int changeReason;

    @JsonProperty("multi_area")
    @NotNull
    private int multiArea;

    public TblPost(int postId, String postCode, int updateShow, int changeReason, int multiArea) {
        this.postId = postId;
        this.postCode = postCode;
        this.updateShow = updateShow;
        this.changeReason = changeReason;
        this.multiArea = multiArea;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public int getUpdateShow() {
        return updateShow;
    }

    public void setUpdateShow(int updateShow) {
        this.updateShow = updateShow;
    }

    public int getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(int changeReason) {
        this.changeReason = changeReason;
    }

    public int getMultiArea() {
        return multiArea;
    }

    public void setMultiArea(int multiArea) {
        this.multiArea = multiArea;
    }
}
