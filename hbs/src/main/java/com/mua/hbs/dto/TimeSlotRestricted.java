package com.mua.hbs.dto;


import com.mua.hbs.model.TimeSlot;
import com.mua.hbs.model.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class TimeSlotRestricted {

    private Long timeSlotId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean taken;

    public TimeSlotRestricted(TimeSlot timeSlot){
        setTimeSlotId(timeSlot.getTimeSlotId());
        setStartTime(timeSlot.getStartTime());
        setEndTime(timeSlot.getEndTime());
        setTaken(timeSlot.getTaken());
    }

}
