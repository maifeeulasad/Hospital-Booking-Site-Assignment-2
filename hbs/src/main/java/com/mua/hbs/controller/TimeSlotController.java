package com.mua.hbs.controller;

import com.mua.hbs.dto.TimeSlotRestricted;
import com.mua.hbs.model.TimeSlot;
import com.mua.hbs.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeslot")
public class TimeSlotController {

    @Autowired
    private TimeSlotService service;

    @GetMapping("/available")
    public List<TimeSlotRestricted> getAllAvailable(){
        return service.getAllAvailable();
    }

    @GetMapping("/detailed")
    public List<TimeSlot> getAll(){
        return service.getAll();
    }

    @PostMapping("/book")
    public Boolean book(@RequestBody TimeSlot timeSlot){
        return service.book(timeSlot);
    }

}
