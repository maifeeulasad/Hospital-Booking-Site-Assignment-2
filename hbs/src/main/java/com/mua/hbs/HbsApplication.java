package com.mua.hbs;

import com.mua.hbs.model.LoginCredential;
import com.mua.hbs.model.TimeSlot;
import com.mua.hbs.model.User;
import com.mua.hbs.model.UserType;
import com.mua.hbs.repository.LoginCredentialRepository;
import com.mua.hbs.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class HbsApplication implements CommandLineRunner {

	@Autowired
	private LoginCredentialRepository loginCredentialRepository;
	@Autowired
	private TimeSlotRepository timeSlotRepository;

	public static void main(String[] args) {
		SpringApplication.run(HbsApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if(loginCredentialRepository.findAll().size()==0){
			createSuperUser();
		}
	}

	void createSuperUser(){
		String username="admin";
		String password="admin";
		LoginCredential loginCredential = new LoginCredential();
		User user = new User();
		loginCredential.setUser(user);
		user.setLoginCredential(loginCredential);
		loginCredential.setUsername(username);
		loginCredential.setPassword(password);
		user.setUserType(UserType.ADMIN);

		loginCredentialRepository.save(loginCredential);

		TimeSlot timeSlot1=new TimeSlot();
		timeSlot1.setStartTime(LocalDateTime.now());
		timeSlot1.setEndTime(LocalDateTime.now().plusHours(1));
		TimeSlot timeSlot2=new TimeSlot();
		timeSlot2.setStartTime(LocalDateTime.now().plusHours(3));
		timeSlot2.setEndTime(LocalDateTime.now().plusHours(4));

		timeSlotRepository.save(timeSlot1);
		timeSlotRepository.save(timeSlot2);
	}
}
