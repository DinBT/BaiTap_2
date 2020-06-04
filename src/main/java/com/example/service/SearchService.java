package com.example.service;

import com.example.AddressApplication;
import com.example.bean.AddressByPostCode;
import com.example.bean.CityByPrefecture;
import com.example.reposistories.TblCityReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for searching by postCode and prefectureCode
 *
 * @author DinBT
 */
@Service
public class SearchService {
    @Autowired
    private TblCityReponsitory tblCityReponsitory;

    /**
     * Service for seaching by postCode
     *
     * @param postCode
     * @return AddressByPostCode Address have search
     */
    public List<AddressByPostCode> searchByPostCode(String postCode) {
        return tblCityReponsitory.searchByPostCode(postCode);
    }

    /**
     * Service for searching by prefectureCode
     *
     * @param prefectureCode
     * @return List<CityByPrefecture>
     */
    public List<CityByPrefecture> searchByPrefectureCode(String prefectureCode) {
        return tblCityReponsitory.searchByPrefectureCode(prefectureCode);
    }
}
