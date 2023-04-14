package com.example.challenge4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Setter @Getter
    @Id
    private int userId;

    private String usernames;

    private String email;

    private String password;

}