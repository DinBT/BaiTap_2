package com.example.responsitory;

import com.example.Bean.AddressByCode;
import com.example.Bean.CityByPostCode;
import com.example.Entity.TblCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchByPrefecture extends JpaRepository<TblCityEntity, Long> {
        @Query(value = "SELECT c.code, p.prefecture, c.city, p.prefecture_kana, c.city_kana,p.prefecture_code" +
                " FROM Tbl_City c " +
                "INNER JOIN tbl_Prefecture p " +
                "WHERE p.prefecture_code = :prefectureCode", nativeQuery = true)
        List<CityByPostCode> searchByPrefectureCode(@Param("prefectureCode") String prefectureCode);
}

