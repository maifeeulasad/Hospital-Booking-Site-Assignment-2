package com.mua.hbs.service;

import com.mua.hbs.dto.TimeSlotRestricted;
import com.mua.hbs.model.TimeSlot;
import com.mua.hbs.model.User;
import com.mua.hbs.model.UserPrincipal;
import com.mua.hbs.model.UserType;
import com.mua.hbs.repository.TimeSlotRepository;
import com.mua.hbs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private UserRepository userRepository;

    public List<TimeSlotRestricted> getAllAvailable(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()) {
            return timeSlotRepository.findAvailable();
        }else{
            return new ArrayList<>();
        }
    }

    public List<TimeSlot> getAll(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()) {
            return timeSlotRepository.findAll();
        }else{
            return new ArrayList<>();
        }
    }

    public Boolean book(TimeSlot timeSlotRec){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()) {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            List<User> users = userRepository.findByLoginCredentialUsername(userPrincipal.getUsername());
            User user=users.get(0);
            if(user.getUserType()== UserType.ADMIN){
                return false;
            }
            List<TimeSlot>timeSlots = timeSlotRepository.findByTimeSlotId(timeSlotRec.getTimeSlotId());
            TimeSlot timeSlot = timeSlots.get(0);
            timeSlot.setTaken(true);
            timeSlot.setUser(user);
            user.getTimeSlotList().add(timeSlot);
            timeSlotRepository.save(timeSlot);
            return true;
        }else{
            return false;
        }
    }

}
