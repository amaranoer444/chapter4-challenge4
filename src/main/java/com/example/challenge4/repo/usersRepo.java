package com.example.challenge4.repo;

import com.example.challenge4.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface usersRepo extends JpaRepository<UserEntity, Integer>{//
    public interface usersRepository extends JpaRepository<User, Integer> {
        @Query("SELECT s FROM UserEntity s WHERE LOWER(s.userId) LIKE LOWER(concat('%',:userId,'%') ) ")
        List<User> findByUserId(int userId);

        @Query("SELECT s FROM UserEntity s WHERE LOWER(s.usernames) LIKE LOWER(concat('%',:usernames,'%') ) ")
        List<User> findByUsernames(String usernames);

        @Query("SELECT s FROM UserEntity s WHERE LOWER(s.email) LIKE LOWER(concat('%',:email,'%') ) ")
        List<User> findByEmail(String email);

        @Query("SELECT s FROM UserEntity s WHERE LOWER(s.password) LIKE LOWER(concat('%',:password,'%') ) ")
        List<User> findByPassword(String password);
    }
}