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
package com.example.entities;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity for tbl_post table
 *
 * @author DinBT
 */
@Entity
@Data
@Table(name = "tbl_post")
public class TblPostEntity {

    @Getter
    @Setter
    @Id
    @Column(name = "post_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("post_id")
    private long postId;

    @Getter
    @Setter
    @Column(name = "post_code", nullable = false, length = 7)
    @JsonProperty("post_code")
    private String postCode;

    @Getter
    @Setter
    @Column(name = "multi_area", nullable = false)
    @JsonProperty("multi_area")
    private int multiArea;

    @Getter
    @Setter
    @Column(name = "update_show", nullable = false)
    @JsonProperty("update_show")
    private int updateShow;

    @Getter
    @Setter
    @Column(name = "change_reason", nullable = false)
    @JsonProperty("change_reason")
    private int changeReason;

    @OneToMany(targetEntity = TblAreaEntity.class, mappedBy = "tblPostEntity", fetch = FetchType.LAZY)
    private List<TblAreaEntity> tblAreaEntityList;

    public TblPostEntity(String postCode, int multiArea, int updateShow, int changeReason) {
        this.postCode = postCode;
        this.multiArea = multiArea;
        this.updateShow = updateShow;
        this.changeReason = changeReason;
    }

    public TblPostEntity() {
    }
}
