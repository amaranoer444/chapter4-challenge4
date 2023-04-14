package com.example.challenge4.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    userRepo userRepo;

    public List<userEntity> findAllUsers(){
        return userRepo.findAll();
    }

    public userEntity findUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public userEntity saveUser(UserEntity user) {
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        UserEntity user = userRepo.findById(id).orElse(null);
        if (user != null) {
            user.setUserId(updatedUser.getUserId());
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userRepo.save(param);
        }
        return null;
    }
}

}
