package com.example.reposistories;

import com.example.entities.TblAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TblAreaReponsitory extends JpaRepository<TblAreaEntity, Long> {
    @Modifying
    @Query(value = "UPDATE tbl_area " +
            "SET area_kana = ?1, area = ?2, city_id = ?3, chome_area = ?4, koaza_area = ?5, multi_post_area = ?6, post_id = ?7, old_post_id = ?8 " +
            "WHERE area_id = ?9", nativeQuery = true)
    void updateTblArea(String areaKana, String area, long cityId, long chomeArea, long koazaArea, long multiPostArea, long postId, long oldPostId, long areaId);

    @Modifying
    @Query(value = "INSERT tbl_area " +
            "SET area_kana = ?1, area = ?2, city_id = ?3, chome_area = ?4, koaza_area = ?5, multi_post_area = ?6, post_id = ?7, old_post_id = ?8 ", nativeQuery = true)
    void addTblArea(String areaKana, String area, long cityId, long chomeArea, long koazaArea, long multiPostArea, long postId, long oldPostId);

    @Modifying
    @Query(value = "DELETE FROM tbl_area WHERE area_id = ?1", nativeQuery = true)
    void deleteTblArea(long areaId);
}
