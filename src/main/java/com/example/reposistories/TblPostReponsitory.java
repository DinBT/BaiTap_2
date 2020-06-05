package com.example.reposistories;

import com.example.entities.TblPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TblPostReponsitory extends JpaRepository<TblPostEntity, Long> {
    @Modifying
    @Query(value = "UPDATE tbl_post " +
            "SET post_code = ?1, update_show = ?2, change_reason = ?3, multi_area = ?4 " +
            "WHERE post_id = ?5", nativeQuery = true)
    void updateTblPost(String postCode, long updateShow, long changeReason, long multiArea, long postId);

    @Modifying
    @Query(value = "INSERT tbl_post " +
            "SET post_code = ?1, update_show = ?2, change_reason = ?3, multi_area = ?4 ", nativeQuery = true)
    void addTblPost(String postCode, long updateShow, long changeReason, long multiArea);

    @Modifying
    @Query(value = "DELETE FROM tbl_post WHERE post_id = ?1", nativeQuery = true)
    void deleteTblPost(long postId);
}
