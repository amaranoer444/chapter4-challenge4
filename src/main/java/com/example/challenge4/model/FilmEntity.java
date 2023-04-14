package com.example.challenge4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "films")
public class FilmEntity {

    @OneToMany(mappedBy = "filmCode", cascade = CascadeType.ALL)
    private List schedulesEntityList;
    public String getFilmCode() {
        return filmCode;
    }

    public void setFilmCode(String filmCode) {
        this.filmCode = filmCode;
    }

    @Id
    @Getter @Setter
    private String filmCode;

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    private String filmName;

    public String getTayangAtauTidak() {
        return tayangAtauTidak;
    }

    public void setTayangAtauTidak(String tayangAtauTidak) {
        this.tayangAtauTidak = tayangAtauTidak;
    }

    private String tayangAtauTidak;

    @Override
    public String toString() {
        return "FilmEntity{" +
                "filmCode='" + filmCode + '\'' +
                ",filmName='" + filmName + '\'' +
                ", tayangAtauTidak='" + tayangAtauTidak + '\''+
                '}';
    }
}
