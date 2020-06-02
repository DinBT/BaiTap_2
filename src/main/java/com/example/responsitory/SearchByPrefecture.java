package com.example.responsitory;

import com.example.Entity.CityByPrefectureEntity;
import com.example.Entity.TblCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchByPrefecture extends JpaRepository<TblCityEntity, Long> {

    @Query("SELECT new com.example.Entity.CityByPrefectureEntity(" +
            "c.code, " +
            "p.prefecture, " +
            "c.city, " +
            "p.prefectureKana, " +
            "c.cityKana, " +
            "p.prefectureCode) " +
            "FROM TblCityEntity c " +
            "INNER JOIN c.tblPrefectureEntity p " +
            "WHERE p.prefectureCode = :prefectureCode")
    List<CityByPrefectureEntity> searchByPrefectureCode(@Param("prefectureCode") String prefectureCode);
}
