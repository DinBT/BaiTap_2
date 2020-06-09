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
package com.example.reponsitorytest;

import com.example.reposistories.TblAreaReponsitory;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test for {@link TblAreaReponsitory}
 *
 * @author DinBT
 */
@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TblAreaReponsitoryTest {
    @Autowired
    private TblAreaReponsitory tblAreaReponsitory;


    /**
     * Test getting data from tbl_area
     */
    @Test
    @FlywayTest(locationsForMigrate = "db/migration")
    public void getAreaKanaByAreaId() {
        String areaKana = tblAreaReponsitory.getAreaKanaById(1);
        assertThat(areaKana, is("ｲｲﾀﾞ"));
    }

    /**
     * Test inserting new data into tbl_area
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void insertTblArea() {
        tblAreaReponsitory.insertTblArea("ｲｲﾀﾞ", "飯田", 1, 0, 0, 1, 1, 1);
        String areaKana = tblAreaReponsitory.getAreaKanaById(1);
        assertThat(areaKana, is("ｲｲﾀﾞ"));
    }

    /**
     * Test updating new data into tbl_area
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void updateTblArea() {
        tblAreaReponsitory.updateTblArea("ｲｲｲﾀｲｲﾀｲﾀﾞ", "飯田田田田", 1, 0, 0, 1, 1, 1, 1);
        String areaKana = tblAreaReponsitory.getAreaKanaById(1);
        assertThat(areaKana, is("ｲｲｲﾀｲｲﾀｲﾀﾞ"));
    }

    /**
     * Test deleting data from tbl_area
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void deleteTblArea() {
        tblAreaReponsitory.deleteFromTblArea(1);
        String areaKana = tblAreaReponsitory.getAreaKanaById(1);
        assertNull(areaKana);
    }

}
