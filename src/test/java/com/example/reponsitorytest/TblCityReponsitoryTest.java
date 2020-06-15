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

import com.example.entities.TblCityEntity;
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

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
     * Test inserting new data into tbl_city
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void insertTblCity() {
        tblCityReponsitory.save(new TblCityEntity("ｼｭｳﾁｸﾞﾝﾓﾘﾏﾁ", "01101", "周智郡森町", 1));
        TblCityEntity tblCityEntity = tblCityReponsitory.getOne(2L);
        assertThat(tblCityEntity.getCode(), is("01101"));
    }

    /**
     * Test updating data into tbl_city
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void updateTblCity() {
        tblCityReponsitory.updateTblCity("01103", "ｼｭｳﾁｸﾞﾝﾓﾘﾏ", "周智郡森", 1, 1);
        TblCityEntity tblCityEntity = tblCityReponsitory.getOne(1L);
        assertThat(tblCityEntity.getCode(), is("01103"));
    }

    /**
     * Test deleting data from tbl_city
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void deleteTblCity() {
        tblCityReponsitory.deleteById(2L);
        TblCityEntity tblCityEntity = tblCityReponsitory.getOne(2L);
        assertNull(tblCityEntity.getCode());
    }

    /**
     * Test inserting duplicate data
     */
    @Test(expected = DataIntegrityViolationException.class)
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void testIntegrityViolation() {
        tblCityReponsitory.save(new TblCityEntity("ｼｭｳﾁｸﾞﾝﾓﾘﾏﾁ", "01101", "周智郡森町", 1));
        tblCityReponsitory.save(new TblCityEntity("ｼｭｳﾁｸﾞﾝﾓﾘﾏﾁ", "01101", "周智郡森町", 1));
    }
}
