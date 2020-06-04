package com.example.ControllersTest;

import com.example.bean.AddressByPostCode;
import com.example.bean.CityByPrefecture;
import com.example.controllers.SearchController;
import com.example.entities.TblCityEntity;
import com.example.reposistories.SearchByPostCode;
import com.example.reposistories.SearchByPrefecture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.naming.directory.SearchControls;
import java.util.ArrayList;
import java.util.List;

import static com.sun.javaws.JnlpxArgs.verify;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {

    @InjectMocks
    private SearchController searchController;

    @Mock
    private SearchByPostCode searchByPostCode;

    @Mock
    private SearchByPrefecture searchByPrefecture;

    @Mock
    private List<CityByPrefecture> mockedList;

    @Captor
    private ArgumentCaptor<CityByPrefecture> argCaptor;

    @Test
    public void verifyArgTest(){
        mockedList.add(new CityByPrefecture());
        mockedList.add(new CityByPrefecture());
        Mockito.verify(mockedList,times(2)).add(argCaptor.capture());
        List<CityByPrefecture> newList = argCaptor.getAllValues();

        mockedList.remove(0);
        Mockito.verify(mockedList).remove(0);
        assertEquals(2,newList.size());
        newList.forEach(System.out::println);
    }

    @Test
    public void searchByPostCode(){
        AddressByPostCode addressByPostCode = new AddressByPostCode();
        when(searchByPostCode.searchByPostCode("0010000")).thenReturn(addressByPostCode);
        AddressByPostCode result = searchByPostCode.searchByPostCode("0010000");
        assertNotNull(result);
    }

    @Test
    public void searchByPrefecture(){
        List<CityByPrefecture> list = new ArrayList<CityByPrefecture>();
        list.add(new CityByPrefecture());
        list.add(new CityByPrefecture());
        when(searchByPrefecture.searchByPrefectureCode("01")).thenReturn(list);
        List<CityByPrefecture> listresult = searchByPrefecture.searchByPrefectureCode("01");
        assertEquals(2,listresult.size());
    }

}
