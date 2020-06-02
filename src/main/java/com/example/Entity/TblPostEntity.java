package com.example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Entity for tbl_post table
 *
 * @author DinBT
 */
@Entity
@Table(name = "tbl_post")
public class TblPostEntity {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "multi_area")
    private int multiArea;

    @Column(name = "update_show")
    private int updateShow;

    @Column(name = "change_reason")
    private int changeReason;
//
//    @OneToMany(targetEntity = TblAreaEntity.class, mappedBy = "id", fetch = FetchType.LAZY)
//    private List<TblAreaEntity> tblAreaEntityList;


    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public int getMultiArea() {
        return multiArea;
    }

    public void setMultiArea(int multiArea) {
        this.multiArea = multiArea;
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

//    public List<TblAreaEntity> getTblAreaEntityList() {
//        return tblAreaEntityList;
//    }
//
//    public void setTblAreaEntityList(List<TblAreaEntity> tblAreaEntityList) {
//        this.tblAreaEntityList = tblAreaEntityList;
//    }

}

