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

import com.example.bean.AddressByPostCode;
import com.example.entities.TblPostEntity;
import com.example.reposistories.TblPostReponsitory;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Test for {@link TblPostReponsitory}
 *
 * @author DinBT
 */
@TestPropertySource("/application-test.properties")
@Rollback
@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TblPostReponsitoryTest {

    @Autowired
    private TblPostReponsitory tblPostReponsitory;


    /**
     * Test searching data by postCode
     */
    @Test
    @FlywayTest(locationsForMigrate = "db/migration")
    public void searchByPostCode() {
        // Record Found
        List<AddressByPostCode> listAddress = tblPostReponsitory.searchByPostCode("9-99-99");
        AddressByPostCode addressByPostCode = listAddress.get(0);
        String area = "飯田";
        String areaKana = "ｲｲﾀﾞ";
        int changeReason = 0;
        int chomeArea = 0;
        String city = "周智郡森町";
        String cityKana = "ｼｭｳﾁｸﾞﾝﾓﾘﾏﾁ";
        String code = "01101";
        int koazaArea = 0;
        int multiArea = 0;
        int multiPostArea = 1;
        String oldPostCode = "060";
        String postCode = "9-99-99";
        String prefecture = "静岡県";
        String prefectureCode = "01";
        String prefectureKana = "ｼｽﾞｵｶｹﾝ";
        int updateShow = 0;

        assertThat(addressByPostCode.getCode(), is(code));
        assertThat(addressByPostCode.getPrefecture(), is(prefecture));
        assertThat(addressByPostCode.getCity(), is(city));
        assertThat(addressByPostCode.getArea(), is(area));
        assertThat(addressByPostCode.getOldPostCode(), is(oldPostCode));
        assertThat(addressByPostCode.getPostCode(), is(postCode));
        assertThat(addressByPostCode.getPrefectureKana(), is(prefectureKana));
        assertThat(addressByPostCode.getCityKana(), is(cityKana));
        assertThat(addressByPostCode.getAreaKana(), is(areaKana));
        assertThat(addressByPostCode.getMultiArea(), is(multiArea));
        assertThat(addressByPostCode.getKoazaArea(), is(koazaArea));
        assertThat(addressByPostCode.getChomeArea(), is(chomeArea));
        assertThat(addressByPostCode.getMultiPostArea(), is(multiPostArea));
        assertThat(addressByPostCode.getUpdateShow(), is(updateShow));
        assertThat(addressByPostCode.getChangeReason(), is(changeReason));
        assertThat(addressByPostCode.getPrefectureCode(), is(prefectureCode));
        // No Record Found
        List<AddressByPostCode> noAddress = tblPostReponsitory.searchByPostCode("1-11-11");
        assertTrue(noAddress.isEmpty());
    }

    /**
     * Test deleting data from tbl_post
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void deleteTblPost() {
        tblPostReponsitory.deleteById(1L);
        assertFalse(tblPostReponsitory.findById(1L).isPresent());
    }

    /**
     * Test inserting data into tbl_post
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void insertTblPost() {
        tblPostReponsitory.save(new TblPostEntity("736", 0, 0, 0));
        String postCode = tblPostReponsitory.getOne(3L).getPostCode();
        assertThat(postCode, is("736"));
    }

    /**
     * Test updating data into tbl_post
     */
    @Test
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void updateTblPost() {
        tblPostReponsitory.updateTblPost("6-66-66", 1, 1, 1, 1);
        String postCode = tblPostReponsitory.getOne(1L).getPostCode();
        assertThat(postCode, is("6-66-66"));
    }


    /**
     * Test inserting duplicate data
     */
    @Test(expected = DataIntegrityViolationException.class)
    @Transactional
    @FlywayTest(locationsForMigrate = "db/migration")
    public void testIntegrityViolation() {
        tblPostReponsitory.save(new TblPostEntity("7-77-77", 0, 0, 0));
        tblPostReponsitory.save(new TblPostEntity("7-77-77", 0, 0, 0));
    }
}
