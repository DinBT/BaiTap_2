package com.example.servicetest;

import com.example.reposistories.TblPostReponsitory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.service.TblPostService;
import com.example.bean.AddressByPostCode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test for {@link TblPostService}
 *
 * @author DinBT
 */
@RunWith(MockitoJUnitRunner.class)
public class TblPostServiceTest {

    @InjectMocks
    private TblPostService postService;

    @Mock
    private TblPostReponsitory tblPostReponsitory;


    /**
     * Setting data before test
     */
    @Before
    public void setUp() {
        List<AddressByPostCode> address = new ArrayList<>();
        address.add(new AddressByPostCode("01101", "北海道", "札幌市中央区", "以下に掲載がない場合", "060", "0405242", "ﾎｯｶｲﾄﾞｳ",
                "ｻｯﾎﾟﾛｼﾁｭｳｵｳｸ", "ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱｲ", 0, 0, 0, 0, 0, 0, "01"));

        List<AddressByPostCode> noaddress = new ArrayList<>();
        when(tblPostReponsitory.searchByPostCode("0405242")).thenReturn(address);
        when(tblPostReponsitory.searchByPostCode("12")).thenReturn(noaddress);
    }

    /**
     * test when not found
     */
    @Test()
    public void testNotFound() {
        assertTrue(postService.searchByPostCode("12").isEmpty());
        verify(tblPostReponsitory, times(1)).searchByPostCode("12");
    }

    /**
     * test method searchByPostCode
     */
    @Test
    public void searchByPostCode() {
        assertNotNull(postService.searchByPostCode("0405242"));
        verify(tblPostReponsitory, times(1)).searchByPostCode("0405242");
    }
}
