package com.mua.hbs.controller;

import com.mua.hbs.model.TimeSlot;
import com.mua.hbs.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timeslot")
public class TimeSlotController {

    @Autowired
    private TimeSlotService service;

    @GetMapping("/available")
    public List<TimeSlot> getAll(){
        return service.getAll();
    }

}
