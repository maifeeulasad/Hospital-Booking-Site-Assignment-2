package com.mua.hbs.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long timeSlotId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private User user;
}
