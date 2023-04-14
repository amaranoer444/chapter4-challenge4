package com.example.challenge4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
public interface schedulesRepo extends JpaRepository<schedulesRepo, Integer> {

    @Query("SELECT s FROM schedulesEntity s WHERE LOWER(s.schedulId) LIKE LOWER(concat('%',:schedulId,'%') ) ")
    List<schedulesRepo> findByschedulId(int schedulId);

    @Query("SELECT s FROM schedulesEntity s WHERE LOWER(s.filmCode) LIKE LOWER(concat('%',:filmCode,'%') ) ")
    List<schedulesRepo> findByFilmCode(String filmCode);

    @Query("SELECT s FROM schedulesEntity s WHERE LOWER(s.tayangFilm) LIKE LOWER(concat('%',:tayangFilm,'%') ) ")
    List<schedulesRepo> findBytayangFilm(Date tayangFilm);

    @Query("SELECT s FROM schedulesEntity s WHERE LOWER(s.jadwalMulai) LIKE LOWER(concat('%',:jadwalMulai,'%') ) ")
    List<schedulesRepo> findByjadwalMulai(Time jadwalMulai);

    @Query("SELECT s FROM schedulesEntity s WHERE LOWER(s.harga) LIKE LOWER(concat('%',:harga,'%') ) ")
    List<schedulesRepo> findByharga(int harga);
}
