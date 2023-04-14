package com.example.challenge4.servis;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    SeatRepo seatRepo;

    public List<SeatEntity> findAllSeats(){
        return seatRepo.findAll();
    }

    public SeatEntity findSeatById(Long id) {
        return seatRepo.findById(id).orElse(null);
    }

    public SeatEntity saveSeat(SeatEntity seat) {
        return seatRepo.save(seat);
    }

    public void deleteSeat(Long id) {
        seatRepo.deleteById(id);
    }

    public SeatEntity updateSeat(Long id, SeatEntity updatedSeat) {
        SeatEntity seat = seatRepo.findById(id).orElse(null);
        if (seat != null) {
            seat.setNoKursi(updatedSeat.getNoKursi());
            seat.setStudioName(updatedSeat.getStudioName());
            // Update other fields as needed
            return seatRepo.save(seat);
        }
        return null;
    }
}

