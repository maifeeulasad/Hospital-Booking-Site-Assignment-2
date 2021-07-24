package com.mua.hbs;

import com.mua.hbs.model.LoginCredential;
import com.mua.hbs.model.User;
import com.mua.hbs.model.UserType;
import com.mua.hbs.repository.LoginCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HbsApplication implements CommandLineRunner {

	@Autowired
	private LoginCredentialRepository loginCredentialRepository;

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
	}
}
