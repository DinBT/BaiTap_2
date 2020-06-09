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
     * Test getting oldPostCode from oldPostId
     */
    @Test
    @FlywayTest(locationsForMigrate = "db/migration")
    public void getOldPostCodeByOldPostId() {
        // Record Found
        String oldPostCode = tblOldPostReponsitory.getOldPostCodeById(1);
        assertThat(oldPostCode, is("060"));
        // No Record Found
        String notFound = tblOldPostReponsitory.getOldPostCodeById(17);
        assertNull(notFound);
    }

    /**
     * Test inserting new data into tbl_old_post
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void insertTblOldPost() {
        tblOldPostReponsitory.insertTblOldPost("174");
        String oldPostCode = tblOldPostReponsitory.getOldPostCodeById(2);
        assertThat(oldPostCode, is("174"));
    }

    /**
     * Test updating new data into tbl_old_post
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void updateTblOldPost() {
        tblOldPostReponsitory.updateTblOldPost("1704", 1);
        String oldPostCode = tblOldPostReponsitory.getOldPostCodeById(1);
        assertThat(oldPostCode, is("1704"));
    }

    /**
     * Test deleting data from tbl_old_post
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void deleteTblOldPost() {
        tblOldPostReponsitory.deleteTblOldPost(2);
        assertNull(tblOldPostReponsitory.getOldPostCodeById(2));
    }

    /**
     * Test inserting duplicate data
     */
    @Test(expected = DataIntegrityViolationException.class)
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void testValidate() {
        tblOldPostReponsitory.insertTblOldPost("174");
        tblOldPostReponsitory.insertTblOldPost("174");
    }
}
