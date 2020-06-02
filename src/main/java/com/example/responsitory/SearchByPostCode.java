package com.example.responsitory;

import com.example.Bean.AddressByCode;
import com.example.Entity.TblCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchByPostCode extends JpaRepository<TblCityEntity, Long> {

    @Query("SELECT new com.example.Bean.AddressByCode(c.code, " +
                    "p.prefecture, " +
                    "c.city, " +
                    "a.area," +
                    "op.oldPostCode," +
                    "pc.postCode, " +
                    "p.prefectureKana, " +
                    "c.cityKana, " +
                    "a.areaKana, " +
                    "pc.multiArea, " +
                    "a.koazaArea, " +
                    "a.chomeArea, " +
                    "a.multiPostArea, " +
                    "pc.updateShow, " +
                    "pc.changeReason, " +
                    "p.prefectureCode )" +
                    "FROM TblCityEntity c " +
                    "INNER JOIN c.tblPrefectureEntity p " +
                    "INNER JOIN c.tblAreaEntity a " +
                    "INNER JOIN a.tblOldPostEntity op " +
                    "INNER JOIN a.tblPostEntity pc " +
                    "WHERE pc.postCode = :postCode")
    AddressByCode searchByPostCode(@Param("postCode") String postCode);
}

