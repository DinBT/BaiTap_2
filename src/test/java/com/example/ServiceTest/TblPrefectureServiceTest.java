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
package com.example.ServiceTest;

import com.example.bean.CityByPrefecture;
import com.example.reposistories.TblPrefectureReponsitory;
import com.example.service.TblPrefectureService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test for {@link TblPrefectureService}
 *
 * @author DinBT
 */
@RunWith(MockitoJUnitRunner.class)
public class TblPrefectureServiceTest {
    @InjectMocks
    private TblPrefectureService tblPrefectureService;

    @Mock
    private TblPrefectureReponsitory tblPrefectureReponsitory;


    /**
     * Setting data before test
     */
    @Before
    public void setUp() {
        List<CityByPrefecture> listCity = new ArrayList<>();
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));

        List<CityByPrefecture> noCity = new ArrayList<>();

        when(tblPrefectureReponsitory.searchByPrefectureCode("13")).thenReturn(listCity);
        when(tblPrefectureReponsitory.searchByPrefectureCode("42")).thenReturn(noCity);
    }

    /**
     * test when not found
     */
    @Test()
    public void testNotFound() {
        assertTrue(tblPrefectureService.searchByPrefectureCode("42").isEmpty());
        verify(tblPrefectureReponsitory, times(1)).searchByPrefectureCode("42");
    }

    /**
     * test method searchByPrefecture
     */
    @Test
    public void searchByPrefecture() {
        assertTrue(tblPrefectureService.searchByPrefectureCode("13").size() == 3);
        verify(tblPrefectureReponsitory, times(1)).searchByPrefectureCode("13");
    }
}

