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
import com.example.controllers.SearchController;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.service.SearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * test for tblCityController class
 *
 * @author DinBT
 */
@RunWith(MockitoJUnitRunner.class)
public class TblCityControllerTest {

    @InjectMocks
    private SearchController tblCityController;

    @Mock
    private SearchService searchService;

    @Captor
    private ArgumentCaptor<String> argCaptor;

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

        when(searchService.searchByPostCode("0405242")).thenReturn(address);
        when(searchService.searchByPrefectureCode("13")).thenReturn(listCity);
    }

    /**
     * test method searchByPostCode
     */
    @Test
    public void searchByPostCode() {
        Assert.assertEquals(200, tblCityController.searchByPostCode("0405242").getStatusCodeValue());
        Assert.assertEquals(1, tblCityController.searchByPostCode("0405242").getBody().getData().size());
        verify(searchService, Mockito.times(2)).searchByPostCode("0405242");
        verify(searchService, Mockito.times(2)).searchByPostCode(argCaptor.capture());
    }

    /**
     * test method searchByPrefecture
     */
    @Test
    public void searchByPrefecture() {
        List<CityByPrefecture> listCity = searchService.searchByPrefectureCode("13");
        Assert.assertEquals(3, listCity.size());
        verify(searchService, Mockito.times(1)).searchByPrefectureCode("13");
        verify(searchService, Mockito.times(1)).searchByPrefectureCode(argCaptor.capture());
    }

    /**
     * test when have not found reccord
     */
    @Test(expected = NotFound.class)
    public void testNotFound() {
        assertTrue(tblCityController.searchByPostCode("02").getStatusCode().is4xxClientError());
        verify(searchService, times(1)).searchByPostCode("02");
        verify(searchService).searchByPostCode(argCaptor.capture());

        assertTrue(tblCityController.searchByPrefectureCode("35").getStatusCode().is4xxClientError());
        verify(searchService, times(0)).searchByPrefectureCode("35");
        verify(searchService, times(0)).searchByPrefectureCode(argCaptor.capture());
    }

    /**
     * test when have bad request error
     */
    @Test(expected = BadRequest.class)
    public void testBadRequest() {
        assertTrue(tblCityController.searchByPostCode("abcs").getStatusCode().is4xxClientError());
        verify(searchService, times(0)).searchByPrefectureCode("abcs");
        verify(searchService).searchByPrefectureCode(argCaptor.capture());

        assertTrue(tblCityController.searchByPostCode(null).getStatusCode().is4xxClientError());
        verify(searchService, times(0)).searchByPrefectureCode(null);
        verify(searchService).searchByPrefectureCode(argCaptor.capture());

        assertTrue(tblCityController.searchByPrefectureCode("abcs").getStatusCode().is4xxClientError());
        verify(searchService, times(0)).searchByPrefectureCode("abcs");
        verify(searchService).searchByPrefectureCode(argCaptor.capture());

        assertTrue(tblCityController.searchByPrefectureCode(null).getStatusCode().is4xxClientError());
        verify(searchService, times(0)).searchByPrefectureCode(null);
        verify(searchService).searchByPrefectureCode(argCaptor.capture());
    }
}