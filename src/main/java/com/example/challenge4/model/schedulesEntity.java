package com.example.challenge4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.TimestampWithTimeZoneJdbcType;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Table(name = "schedules")
class schedulesEntity {

    @Id
    @Getter @Setter

    private int schedulId;

    private String filmCode;

    private Date tayangFilm;

    private Time jadwalMulai;

    private int harga;

}
