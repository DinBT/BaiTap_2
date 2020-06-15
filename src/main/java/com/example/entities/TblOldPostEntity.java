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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity for tbl_old_post table
 *
 * @author DinBT
 */
@Entity
@Data
@Table(name = "tbl_old_post")
public class TblOldPostEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @Column(name = "old_post_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("old_post_id")
    private long oldPostId;

    @Getter
    @Setter
    @Column(name = "old_post_code", nullable = false, length = 5)
    @JsonProperty("old_post_code")
    private String oldPostCode;
//
//    @OneToMany(targetEntity = TblAreaEntity.class, mappedBy = "tblOldPostEntity", fetch = FetchType.LAZY)
//    private List<TblAreaEntity> tblAreaEntityList;

    public TblOldPostEntity(String oldPostCode) {
        this.oldPostCode = oldPostCode;
    }

    public TblOldPostEntity() {
    }
}
