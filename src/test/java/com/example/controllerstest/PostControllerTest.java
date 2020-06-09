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
package com.example.controllerstest;


import com.example.bean.AddressByPostCode;
import com.example.controllers.PostController;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.service.TblPostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Test for {@link PostController}
 *
 * @author DinBT
 */
@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {

    @InjectMocks
    private PostController postController;

    @Mock
    private TblPostService tblPostService;

    @Captor
    private ArgumentCaptor<String> argCaptor;

    @Before
    public void setUp() {
        List<AddressByPostCode> listAddress = new ArrayList<>();
        listAddress.add(new AddressByPostCode("01101", "北海道", "札幌市中央区", "以下に掲載がない場合", "060", "0405242", "ﾎｯｶｲﾄﾞｳ",
                "ｻｯﾎﾟﾛｼﾁｭｳｵｳｸ", "ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱｲ", 0, 0, 0, 0, 0, 0, "01"));
        when(tblPostService.searchByPostCode("0405242")).thenReturn(listAddress);

        when(tblPostService.searchByPostCode("1704")).thenThrow(new NotFound(""));
    }

    /**
     * test method searchByPostCode
     */
    @Test
    public void searchByPostCode() {
        Assert.assertEquals(200, postController.searchByPostCode("0405242").getStatusCodeValue());
        Assert.assertEquals(1, postController.searchByPostCode("0405242").getBody().getData().size());
        verify(tblPostService, Mockito.times(2)).searchByPostCode("0405242");
        verify(tblPostService, Mockito.times(2)).searchByPostCode(argCaptor.capture());
    }


    /**
     * test when have not found reccord
     */
    @Test(expected = NotFound.class)
    public void testNotFound() {
        assertTrue(postController.searchByPostCode("1704").getStatusCode().is4xxClientError());
        verify(tblPostService, times(1)).searchByPostCode("1704");
        verify(tblPostService).searchByPostCode(argCaptor.capture());
    }

    /**
     * test when have bad request error
     */
    @Test(expected = BadRequest.class)
    public void testBadRequest() {
        assertTrue(postController.searchByPostCode("abcs").getStatusCode().is4xxClientError());
        verify(tblPostService, times(0)).searchByPostCode("abcs");
        verify(tblPostService).searchByPostCode(argCaptor.capture());

        assertTrue(postController.searchByPostCode(null).getStatusCode().is4xxClientError());
        verify(tblPostService, times(0)).searchByPostCode(null);
        verify(tblPostService).searchByPostCode(argCaptor.capture());
    }
}

