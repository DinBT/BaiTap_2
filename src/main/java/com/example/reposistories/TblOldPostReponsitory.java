package com.example.reposistories;

import com.example.entities.TblOldPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TblOldPostReponsitory extends JpaRepository<TblOldPostEntity, Long> {
    @Modifying
    @Query(value = "UPDATE tbl_old_post " +
            "SET old_post_code = ?1 WHERE old_post_id = ?2", nativeQuery = true)
    void updateTblOldPost(String oldPostCode, long oldPostId);

    @Modifying
    @Query(value = "INSERT tbl_old_post " +
            "SET old_post_code = ?1 ", nativeQuery = true)
    void addTblOldPost(String oldPostCode);

    @Modifying
    @Query(value = "DELETE FROM tbl_old_post  WHERE old_post_id = ?1", nativeQuery = true)
    void deleteTblOldPost(long oldPostId);
}
