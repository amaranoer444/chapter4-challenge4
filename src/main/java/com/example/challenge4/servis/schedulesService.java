package com.example.challenge4.servis;

import com.example.challenge4.model.FilmEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class schedulesService {

    @Autowired
    ScheduleRepo scheduleRepo;

    public SchedulesEntity findAll(){
        return (FilmEntity) SchedulesRepo.findAll();
    }

    public SchedulesEntity addSchedules(schedulesService param){
        Optional<SchedulesEntity> film = SchedulesRepo.findById(param.getSchedulesID());
        if(film.isPresent()){
            throw new RuntimeException("schedulesId " + "'" + param.getSchedulesId() + "'" + " Already Exists");
        }else {
            return scheduleRepo.save(param);
        }
    }

    public schedulesEntity updateSchedules(schedulesEntity param){
        schedulesEntity updateSchedules = scheduleRepo.findById(param.getScheduleId()).get();
        updateSchedules.setSchedukesId(param.getScheduleId());
        updateSchedules.setTayangFilm(param.getTayangFilm());
        updateSchedules.setJadwalMulai(param.getJadwalMulaiFilm());
        updateSchedules.setHarga(param.getTHarga());
        return scheduleRepo.save(updateSchedules);
    }

    public schedulesService deleteScedules(SchedulesEntity param){
        scheduleEntity deleteSchedules = scheduleRepo.findById(param.getSchedules()).get();
        scheduleRepo.delete(param);
        return deleteScedules;
    }

    public Pageable<scheduleEntity> getAllSchedules(int page, int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return scheduleRepo.findAll(pageable);
    }
}
