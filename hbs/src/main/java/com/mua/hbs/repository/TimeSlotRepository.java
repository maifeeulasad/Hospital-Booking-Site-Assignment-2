package com.mua.hbs.repository;

import com.mua.hbs.dto.TimeSlotRestricted;
import com.mua.hbs.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot,Long> {

    List<TimeSlot>findByTimeSlotId(Long timeSlotId);

    @Query("select new com.mua.hbs.dto.TimeSlotRestricted(ts) from TimeSlot ts where ts.taken=false")
    List<TimeSlotRestricted>findAvailable();

    @Query("select new com.mua.hbs.dto.TimeSlotRestricted(ts) from TimeSlot ts where ts.user.userId=?1")
    List<TimeSlotRestricted>findMine(Long userId);
}