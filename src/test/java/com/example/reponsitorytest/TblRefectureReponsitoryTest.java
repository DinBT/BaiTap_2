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

 import com.example.bean.CityByPrefecture;
 import com.example.entities.TblPrefectureEntity;
 import com.example.reposistories.TblPrefectureReponsitory;
 import org.flywaydb.test.annotation.FlywayTest;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.dao.DataIntegrityViolationException;
 import org.springframework.test.context.ActiveProfiles;
 import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;

 import static junit.framework.TestCase.assertNull;
 import static junit.framework.TestCase.assertTrue;
 import static org.hamcrest.MatcherAssert.assertThat;
 import static org.hamcrest.Matchers.is;

 /**
  * Test for {@link TblPrefectureReponsitory}
  *
  * @author DinBT
  */
 @ActiveProfiles("test")
 @SpringBootTest
 @RunWith(SpringJUnit4ClassRunner.class)
 public class TblRefectureReponsitoryTest {

     @Autowired
     private TblPrefectureReponsitory tblRefectureReponsitory;


     /**
      * Test searching data by prefectureCode
      */
     @Test
     @FlywayTest(locationsForMigrate = "db/migration")
     public void searchByPrefectureCode() {
         // Record found
         List<CityByPrefecture> listCity = tblRefectureReponsitory.searchByPrefectureCode("01");
         CityByPrefecture cityByPrefecture = listCity.get(0);
         String code = "01101";
         String prefecture = "静岡県";
         String city = "周智郡森町";
         String prefectureKana = "ｼｽﾞｵｶｹﾝ";
         String cityKana = "ｼｭｳﾁｸﾞﾝﾓﾘﾏﾁ";
         String prefectureCode = "01";

         assertThat(cityByPrefecture.getCode(), is(code));
         assertThat(cityByPrefecture.getPrefecture(), is(prefecture));
         assertThat(cityByPrefecture.getCity(), is(city));
         assertThat(cityByPrefecture.getPrefectureKana(), is(prefectureKana));
         assertThat(cityByPrefecture.getCityKana(), is(cityKana));
         assertThat(cityByPrefecture.getPrefectureCode(), is(prefectureCode));
         // No record found
         List<CityByPrefecture> prefectureDtoEmpty = tblRefectureReponsitory.searchByPrefectureCode("02");
         assertTrue(prefectureDtoEmpty.isEmpty());
     }

     /**
      * Test inserting data into tbl_prefecture
      */
     @Test
     @Transactional
     @FlywayTest(locationsForMigrate = "db/migration")
     public void insertTblPrefecture() {
         tblRefectureReponsitory.save(new TblPrefectureEntity("ﾎｯｶｲﾄﾞｳ", "北海道", "02"));
         TblPrefectureEntity tblPrefectureEntity = tblRefectureReponsitory.getOne(2L);
         assertThat(tblPrefectureEntity.getPrefectureKana(), is("ﾎｯｶｲﾄﾞｳ"));
     }

     /**
      * Test updating data into tbl_prefecture
      */
     @Test
     @Transactional
     @FlywayTest(locationsForMigrate = "db/migration")
     public void updateTblPrefecture() {
         tblRefectureReponsitory.updateTblPrefecture("一一一一一", "ァァァァァ", "03", 1);
         TblPrefectureEntity tblPrefectureEntity = tblRefectureReponsitory.getOne(1L);
         assertThat(tblPrefectureEntity.getPrefectureKana(), is("一一一一一"));
     }

     /**
      * Test deleting data from tbl_prefecture
      */
     @Test
     @Transactional
     @FlywayTest(locationsForMigrate = "db/migration")
     public void deleteTblPrefecture() {
         tblRefectureReponsitory.deleteById(2L);
         TblPrefectureEntity tblPrefectureEntity = tblRefectureReponsitory.getOne(2L);
         assertNull(tblPrefectureEntity);
     }

     /**
      * Test inserting duplicate data
      */
     @Test(expected = DataIntegrityViolationException.class)
     @Transactional
     @FlywayTest(locationsForMigrate = "db/migration")
     public void testIntegrityViolation() {
         tblRefectureReponsitory.save(new TblPrefectureEntity("ﾎｯｶｲﾄﾞｳ", "北海道", "02"));
         tblRefectureReponsitory.save(new TblPrefectureEntity("ﾎｯｶｲﾄﾞｳ", "北海道", "02"));
     }

 }
