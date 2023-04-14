package com.example.challenge4.repo;

import com.example.challenge4.model.SeatEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository
public interface seatsRepo extends JpaRepository<seatsEntity, Integer> {
    @Query("SELECT s FROM seatsEntity s WHERE LOWER(s.noKursi) LIKE LOWER(concat('%',:noKursi,'%') ) ")
    List<seatsRepo> findBynoKursi(int noKursi);

    @Query("SELECT s FROM seatsEntity s WHERE LOWER(s.harga) LIKE LOWER(concat('%',:studioName,'%') ) ")
    List<seatsRepo> findBystudioName(char studioName);
}
