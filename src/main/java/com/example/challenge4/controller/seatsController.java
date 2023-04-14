package com.example.challenge4.controller;

import com.example.challenge4.model.SeatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "seats")
public class SeatContoller {

    @Autowired
    SeatService seatService;

    @GetMapping
    public List<SeatEntity> findAllSeat(){
        return seatService.findAllSeat();
    }

}
