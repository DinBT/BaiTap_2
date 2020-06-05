package com.example.reposistories;

import com.example.entities.TblPrefectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TblPrefectureReponsitory extends JpaRepository<TblPrefectureEntity, Long> {
    @Modifying
    @Query(value = "UPDATE tbl_prefecture " +
            "SET prefecture_kana = ?1, prefecture = ?2, prefecture_code = ?3 " +
            "WHERE prefecture_id = ?4 ", nativeQuery = true)
    void updateTblPrefecture(String prefectureKana, String prefecture, String prefectureCode, long prefectureId);

    @Modifying
    @Query(value = "INSERT tbl_prefecture " +
            "SET prefecture_kana = ?1, prefecture = ?2, prefecture_code = ?3 ", nativeQuery = true)
    void addTblPrefecture(String prefectureKana, String prefecture, String prefectureCode);

    @Modifying
    @Query(value = "DELETE FROM tbl_prefecture WHERE prefecture_id = ?1 ", nativeQuery = true)
    void deleteTblPrefecture(long prefectureId);
}
