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

import com.example.entities.TblAreaEntity;
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
     * Test inserting new data into tbl_area
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void insertTblArea() {
        tblAreaReponsitory.save(new TblAreaEntity("ｲｲｲﾀｲｲﾀｲﾞ", "飯田田田", 1, 0, 0, 1, 1, 1));
        TblAreaEntity tblAreaEntity = tblAreaReponsitory.getOne(2L);
        assertThat(tblAreaEntity.getAreaKana(), is("ｲｲｲﾀｲｲﾀｲﾞ"));
    }

    /**
     * Test updating new data into tbl_area
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void updateTblArea() {
        tblAreaReponsitory.updateTblArea("ｲｲｲﾀｲｲﾀｲﾀﾞ", "飯田田田田", 1, 0, 0, 1, 1, 1, 1);
        TblAreaEntity tblAreaEntity = tblAreaReponsitory.getOne(1L);
        assertThat(tblAreaEntity.getAreaKana(), is("ｲｲｲﾀｲｲﾀｲﾀﾞ"));
    }

    /**
     * Test deleting data from tbl_area
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void deleteTblArea() {
        tblAreaReponsitory.deleteById(1L);
        TblAreaEntity tblAreaEntity = tblAreaReponsitory.getOne(1L);
        assertNull(tblAreaEntity);
    }

}
