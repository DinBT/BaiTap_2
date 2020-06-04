package com.example.ControllersTest;

import com.example.bean.AddressByPostCode;
import com.example.bean.CityByPrefecture;
import com.example.controllers.TblCityController;
import com.example.reposistories.TblCityReponsitory;
import com.example.service.SearchService;
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

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class TblCityControllerTest {

    @InjectMocks
    private TblCityController tblCityController;

    @Mock
    private SearchService searchService;


    @Mock
    private List<CityByPrefecture> mockedList;

    @Captor
    private ArgumentCaptor<CityByPrefecture> argCaptor;

    @Test
    public void verifyArgTest() {
        mockedList.add(new CityByPrefecture());
        mockedList.add(new CityByPrefecture());
        Mockito.verify(mockedList, times(2)).add(argCaptor.capture());
        List<CityByPrefecture> newList = argCaptor.getAllValues();

        mockedList.remove(0);
        Mockito.verify(mockedList).remove(0);
        assertEquals(2, newList.size());
        newList.forEach(System.out::println);
    }

    @Test
    public void searchByPostCode() {
        AddressByPostCode addressByPostCode = new AddressByPostCode();
        when(tblCityController.searchByPostCode("0010000")).thenReturn(addressByPostCode);
        AddressByPostCode result = tblCityController.searchByPostCode("0010000");
        assertNotNull(result);
    }

    @Test
    public void searchByPrefecture() {
        List<CityByPrefecture> list = new ArrayList<CityByPrefecture>();
        list.add(new CityByPrefecture());
        list.add(new CityByPrefecture());
        list.add(new CityByPrefecture());
        when(tblCityController.searchByPrefectureCode("01")).thenReturn(list);
        List<CityByPrefecture> listresult = tblCityController.searchByPrefectureCode("01");
        assertEquals(3, listresult.size());
    }

    /**
     * Setting up Testing Data
     */
    @Before
    public void setUp() {
        List<AddressByPostCode> address = new ArrayList<>();
        address.add(new AddressByPostCode("01101", "北海道", "札幌市中央区", "以下に掲載がない場合", "060", "0600000", "ﾎｯｶｲﾄﾞｳ",
                "ｻｯﾎﾟﾛｼﾁｭｳｵｳｸ", "ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱｲ", 0, 0, 0, 0, 0, 0, "01"));
        address.add(new AddressByPostCode("01101", "北海道", "札幌市中央区", "以下に掲載がない場合", "060", "0600000", "ﾎｯｶｲﾄﾞｳ",
                "ｻｯﾎﾟﾛｼﾁｭｳｵｳｸ", "ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱｲ", 0, 0, 0, 0, 0, 0, "01"));
        address.add(new AddressByPostCode("01101", "北海道", "札幌市中央区", "以下に掲載がない場合", "060", "0600000", "ﾎｯｶｲﾄﾞｳ",
                "ｻｯﾎﾟﾛｼﾁｭｳｵｳｸ", "ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱｲ", 0, 0, 0, 0, 0, 0, "01"));
        when(searchService.searchByPostCode("0600000")).thenReturn(address);
        when(searchService.searchByPostCode("0600020")).thenReturn(address);

        List<CityByPrefecture> listCity = new ArrayList<>();
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));
        listCity.add(new CityByPrefecture("13101", "東京都", "千代田区", "ﾄｳｷｮｳﾄ", "ﾁﾖﾀﾞｸ", "13"));
        when(searchService.searchByPrefectureCode("10")).thenReturn(listCity);

        List<AddressByPostCode> emptyPostList = new ArrayList<>();
        when(searchService.searchByPostCode("1704")).thenReturn(emptyPostList);

        List<CityByPrefecture> emptyPrefectureList = new ArrayList<>();
        when(searchService.searchByPrefectureCode("17")).thenReturn(emptyPrefectureList);
    }
}
