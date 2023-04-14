package com.example.challenge4.respon;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FilmResponse <T>{

    private String status;
    private String message;
    private T datas;

    public FilmResponse(String status, String message, T datas) {
        this.status = status;
        this.message = message;
        this.datas = datas;
    }

    public FilmResponse() {
    }
}