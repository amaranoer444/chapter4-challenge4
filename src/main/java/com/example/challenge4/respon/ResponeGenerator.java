package com.example.challenge4.respon;

import org.springframework.stereotype.Component;

@Component
public class FIlmResponseGenerator {

    public <T> FilmResponse <T> successResponse(T datas, String message){
        FilmResponse response = new FilmResponse<>();
        response.setStatus("200");
        response.setMessage(message);
        response.setDatas(datas);
        return response;
    }

    public <T> FilmResponse <T> failedResponse(String message){
        FilmResponse response = new FilmResponse<>();
        response.setStatus("500");
        response.setMessage(message);
        return response;
    }

}
