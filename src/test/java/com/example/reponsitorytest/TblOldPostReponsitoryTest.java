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

import com.example.entities.TblOldPostEntity;
import com.example.entities.TblPrefectureEntity;
import com.example.reposistories.TblOldPostReponsitory;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Test for {@link TblOldPostReponsitory}
 *
 * @author DinBT
 */
@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TblOldPostReponsitoryTest {

    @Autowired
    private TblOldPostReponsitory tblOldPostReponsitory;


    /**
     * Test inserting new data into tbl_old_post
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void saveTblOldPostEntity() {
        TblOldPostEntity oldPostEntity = tblOldPostReponsitory.save(new TblOldPostEntity("1325"));
        assertThat(oldPostEntity.getOldPostCode(), is("1325"));
    }

    /**
     * Test updating new data into tbl_old_post
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void updateTblOldPost() {
        tblOldPostReponsitory.updateTblOldPost("1704", 1);
        TblOldPostEntity oldPostEntity = tblOldPostReponsitory.getOne(1L);
        assertThat(oldPostEntity.getOldPostCode(), is("1704"));
    }

    /**
     * Test deleting data from tbl_old_post
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void deleteTblOldPost() {
        tblOldPostReponsitory.deleteById(1L);
        assertFalse(tblOldPostReponsitory.findById(1L).isPresent());

    }

    /**
     * Test inserting duplicate data
     */
    @Test(expected = DataIntegrityViolationException.class)
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void testIntegrityViolation() {
        tblOldPostReponsitory.save(new TblOldPostEntity("174"));
        tblOldPostReponsitory.save(new TblOldPostEntity("174"));
    }
}
