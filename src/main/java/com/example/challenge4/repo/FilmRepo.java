package com.example.challenge4.repo;

import com.example.challenge4.model.FilmEntity;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface FilmRepo extends JpaRepository<FilmEntity, String> {

        @Query("SELECT s FROM FilmEntity s WHERE LOWER(s.filmName) LIKE LOWER(concat('%',:filmName,'%') ) ")
        List<FilmEntity> findByFilmName(String filmName);

        @Query("SELECT s FROM FilmEntity s WHERE LOWER(s.filmCode) LIKE LOWER(concat('%',:filmCode,'%') ) ")
        List<FilmEntity> findByFilmCode(String filmCode);

        @Query("SELECT s FROM FilmEntity s WHERE LOWER(s.tayangAtauTidak) LIKE LOWER(concat('%',:email,'%') ) ")
        List<FilmEntity> findByTayangAtauTidak(String tayangAtauTidak);
    }