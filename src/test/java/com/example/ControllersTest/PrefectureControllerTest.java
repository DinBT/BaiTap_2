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

import com.example.bean.CityByPrefecture;
import com.example.controllers.PrefectureController;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.service.TblPrefectureService;
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
 * Test for {@link PrefectureController}
 *
 * @author DinBT
 */
@RunWith(MockitoJUnitRunner.class)
public class PrefectureControllerTest {
    @InjectMocks
    private PrefectureController tblCityController;

    @Mock
    private TblPrefectureService tblPrefectureService;

    @Captor
    private ArgumentCaptor<String> argCaptor;

    /**
     * Setting data before test
     */
    @Before
    public void setUp() {
        List<CityByPrefecture> listCity = new ArrayList<>();
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));

        when(tblPrefectureService.searchByPrefectureCode("13")).thenReturn(listCity);
    }

    /**
     * test method searchByPrefecture
     */
    @Test
    public void searchByPrefecture() {
        List<CityByPrefecture> listCity = tblPrefectureService.searchByPrefectureCode("13");
        Assert.assertEquals(3, listCity.size());
        verify(tblPrefectureService, Mockito.times(1)).searchByPrefectureCode("13");
        verify(tblPrefectureService, Mockito.times(1)).searchByPrefectureCode(argCaptor.capture());
    }

    /**
     * test when have not found reccord
     */
    @Test(expected = NotFound.class)
    public void testNotFound() {
        assertTrue(tblCityController.searchByPrefectureCode("35").getStatusCode().is4xxClientError());
        verify(tblPrefectureService, times(0)).searchByPrefectureCode("35");
        verify(tblPrefectureService, times(0)).searchByPrefectureCode(argCaptor.capture());
    }

    /**
     * test when have bad request error
     */
    @Test(expected = BadRequest.class)
    public void testBadRequest() {

        assertTrue(tblCityController.searchByPrefectureCode("abcs").getStatusCode().is4xxClientError());
        verify(tblPrefectureService, times(0)).searchByPrefectureCode("abcs");
        verify(tblPrefectureService).searchByPrefectureCode(argCaptor.capture());

        assertTrue(tblCityController.searchByPrefectureCode(null).getStatusCode().is4xxClientError());
        verify(tblPrefectureService, times(0)).searchByPrefectureCode(null);
        verify(tblPrefectureService).searchByPrefectureCode(argCaptor.capture());
    }
}
