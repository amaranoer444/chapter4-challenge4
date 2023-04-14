package com.example.challenge4.servis;

import com.example.challenge4.model.FilmEntity;
import com.example.challenge4.repo.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepo filmRepo;

    public FilmEntity findAll(){
        return (FilmEntity) filmRepo.findAll();
    }

    public FilmEntity addFilm(FilmEntity param){
        Optional<FilmEntity> film = filmRepo.findById(param.getFilmCode());
        if(film.isPresent()){
            throw new RuntimeException("Film Code " + "'" + param.getFilmCode() + "'" + " Already Exists");
        }else {
            return filmRepo.save(param);
        }
    }

    public FilmEntity updateFilm(FilmEntity param){
        FilmEntity updateFilm = filmRepo.findById(param.getFilmCode()).get();
        updateFilm.setFilmName(param.getFilmName());
        updateFilm.setTayangAtauTidak(param.getTayangAtauTidak());
        return filmRepo.save(updateFilm);
    }

    public FilmEntity deleteFilm(FilmEntity param){
        FilmEntity deleteFilm = filmRepo.findById(param.getFilmCode()).get();
        filmRepo.delete(param);
        return deleteFilm;
    }

    public Pageable<FilmEntity> getAllFilm(int page, int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return filmRepo.findAll(pageable);
    }


}
