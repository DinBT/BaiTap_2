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

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.example.reposistories.TblCityReponsitory;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test for {@link TblCityReponsitory}
 *
 * @author DinBT
 */
@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TblCityReponsitoryTest {

    @Autowired
    private TblCityReponsitory tblCityReponsitory;


    /**
     * Test getting data from tbl_city
     */
    @Test
    @FlywayTest(locationsForMigrate = "db/migration")
    public void getCodeById() {
        String code = tblCityReponsitory.getCodeById(1);
        assertThat(code, is("01101"));
    }

    /**
     * Test inserting new data into tbl_city
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void insertTblCity() {
        tblCityReponsitory.insertTblCity("01101", "ｼｭｳﾁｸﾞﾝﾓﾘﾏﾁ", "周智郡森町", 1);
        String code = tblCityReponsitory.getCodeById(2);
        assertThat(code, is("01101"));
    }

    /**
     * Test updating data into tbl_city
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void updateTblCity() {
        tblCityReponsitory.updateTblCity("01101", "ｼｭｳﾁｸﾞﾝﾓﾘﾏ", "周智郡森", 1, 1);
        String code = tblCityReponsitory.getCodeById(1);
        assertThat(code, is("01101"));
    }

    /**
     * Test deleting data from tbl_city
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void deleteTblCity() {
        tblCityReponsitory.deleteTblCity(2);
        String code = tblCityReponsitory.getCodeById(2);
        assertNull(code);
    }

    /**
     * Test inserting duplicate data
     */
    @Test(expected = DataIntegrityViolationException.class)
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void testValidate() {
        tblCityReponsitory.insertTblCity("01101", "ｼｭｳﾁｸﾞﾝﾓﾘﾏﾁ", "周智郡森町", 1);
        tblCityReponsitory.insertTblCity("01101", "ｼｭｳﾁｸﾞﾝﾓﾘﾏﾁ", "周智郡森町", 1);
    }
}
