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
package com.example.ControllersTest;

import com.example.bean.AddressByPostCode;
import com.example.bean.CityByPrefecture;
import com.example.controllers.TblCityController;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.reposistories.TblCityReponsitory;
import com.example.service.SearchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * test for service action
 *
 * @author DinBT
 */
@RunWith(MockitoJUnitRunner.class)
public class TestService {

    @InjectMocks
    private SearchService searchService;

    @Mock
    private TblCityReponsitory tblCityReponsitory;


    /**
     * Setting data before test
     */
    @Before
    public void setUp() {
        List<AddressByPostCode> address = new ArrayList<>();
        address.add(new AddressByPostCode("01101", "北海道", "札幌市中央区", "以下に掲載がない場合", "060", "0405242", "ﾎｯｶｲﾄﾞｳ",
                "ｻｯﾎﾟﾛｼﾁｭｳｵｳｸ", "ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱｲ", 0, 0, 0, 0, 0, 0, "01"));


        List<CityByPrefecture> listCity = new ArrayList<>();
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));

        List<AddressByPostCode> noaddress = new ArrayList<>();
        List<CityByPrefecture> noCity = new ArrayList<>();

        when(tblCityReponsitory.searchByPostCode("0405242")).thenReturn(address);
        when(tblCityReponsitory.searchByPostCode("12")).thenReturn(noaddress);
        when(tblCityReponsitory.searchByPrefectureCode("13")).thenReturn(listCity);
        when(tblCityReponsitory.searchByPrefectureCode("42")).thenReturn(noCity);
    }

    /**
     * test when not found
     */
    @Test()
    public void testNotFound() {
        assertTrue(searchService.searchByPostCode("12").isEmpty());
        verify(tblCityReponsitory, times(1)).searchByPostCode("12");

        assertTrue(searchService.searchByPrefectureCode("42").isEmpty());
        verify(tblCityReponsitory, times(1)).searchByPrefectureCode("42");
    }

    /**
     * test method searchByPostCode
     */
    @Test
    public void searchByPostCode() {
        assertNotNull(searchService.searchByPostCode("0405242"));
        verify(tblCityReponsitory, times(1)).searchByPostCode("0405242");
    }

    /**
     * test method searchByPrefecture
     */
    @Test
    public void searchByPrefecture() {
        assertTrue(searchService.searchByPrefectureCode("13").size() == 3);
        verify(tblCityReponsitory, times(1)).searchByPrefectureCode("13");
    }

}
