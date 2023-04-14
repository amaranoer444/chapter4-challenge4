package com.example.challenge4.controller;

import com.example.challenge4.model.FilmEntity;
import com.example.challenge4.servis.fIlmResponseGenerator;
import com.example.challenge4.respon.FilmResponse;
import com.example.challenge4.servis.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping
    public List<FilmEntity> findAllFilms(){
        return (List<FilmEntity>) filmService.findAll();
    }

    @PostMapping(value = "addFilm")
    public FilmResponse<FilmEntity> addFilm(@RequestBody FilmEntity param){
        try {
            log.info("Successfully added");
            return log.debug(filmService.addFilm(param), "Success Menambahkan Film");
        }catch (Exception e){
            return log.failedResponse(e.getMessage());
        }

}
    @PutMapping(value = "updateFilm")
    public FilmEntity updateFilm(@RequestBody FilmEntity param){
        return filmService.updateFilm(param);
    }

    @DeleteMapping(value = "deleteFilm/{param}")
    public FilmEntity deleteFilm(@PathVariable FilmEntity param){
        return filmService.deleteFilm(param);
    }

    @GetMapping(value = "page")
    public FilmResponse<List<FilmEntity>> findAll(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10") int pageSize){
        Page<FilmEntity> filmResult = filmService.getAllFilm(page, pageSize);
        List<FilmEntity> filmData = filmResult.getContent();
        long totalItems = filmResult.getTotalElements();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(totalItems));
        log.info("Success");
        return fIlmResponseGenerator.successResponse(filmData, "Success");
    }

}