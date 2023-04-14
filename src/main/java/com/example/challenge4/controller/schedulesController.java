package com.example.challenge4.controller;

import com.example.challenge4.model.ScheduleEntity;
import com.example.challenge4.servis.schedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.concurrent.ScheduledExecutorService;
import java.util.List;

    @RestController
    @RequestMapping(value = "/schedule")
    public class scheduleService {
        @Autowired
        scheduleService ss;
        @GetMapping
        public List<Schedules> getAll(){ // read data
            return ss.getAll();
        }

        @PostMapping(value = "/schadules-add")
        public Schedules addOne(@RequestBody Schedules param){ // add data
            return ss.createAll(param);
        }

        private Schedules createAll(Schedules param) {
        }

        @PutMapping(value = "/schedules-update")
        public Schedules updateOne(@RequestBody Schedules param){ // update data
            return ss.updateOne(param);
        }

        @DeleteMapping(value = "/delete/{schedules_id}")
        public Schedules deleteOne(@PathVariable int schedules_id){ // delete data
            return ss.deleteOne(schedules_id);
        }

        @PostMapping(value = "/schedules-addList")
        public List<Schedules> MakeAll(@RequestBody List<Schedules> parame){ // add data
            return ss.MakeAll(parame);
        }

        @GetMapping(value = "/check-tayangFilm/{schedules}")
        public List<Schedules> findBytayangFilm(@PathVariable("tayangFilm") int tayangFilm){
            return ss.findBytayangFilm(tayangFilm);
        }

        @GetMapping(value = "/check-jadwalTayang/{jadwaltayang}")
        public List<Schedules> findByEmail(@PathVariable("jadwaltayang")Time jadwalTayang){
            return ss.findByjadwalTayang(jadwalTayang);
        }
        @GetMapping(value = "/check-harga/{schedules}")
        public List<Schedules> findByharga(@PathVariable("harga") int harga){
            return ss.findBytayangFilm(harga);
        }
    }

}
}
