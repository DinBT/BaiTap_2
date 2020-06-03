package com.example.responsitory;

import com.example.Bean.AddressByCode;
import com.example.Entity.TblAreaEntity;
import com.example.Entity.TblCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchByPostCode extends JpaRepository<TblCityEntity, Long> {
    @Query(value = "SELECT  c.code,  p.prefecture, c.city, a.area, op.old_post_code, pc.post_code,  " +
                    "p.prefecture_kana,  c.city_kana,  a.area_kana,  pc.multi_area,  a.koaza_area," +
                    " a.chome_area,  a.multi_post_area,  pc.update_show, pc.change_reason,  p.prefecture_code  " +
                    "FROM tbl_city c INNER JOIN tbl_Prefecture p On c.prefecture_id = p.prefecture_id" +
            "INNER JOIN (tbl_area a INNER JOIN tbl_Old_Post op On a.old_post_id=op.old_post_id" +
            "INNER JOIN tbl_Post pc on a.post_id=pc.post_id) on c.city_id = a.city_id WHERE pc.post_Code :postCode",nativeQuery = true)
    AddressByCode searchByPostCode(@Param("postCode") String postCode);
}

