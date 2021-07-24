package com.mua.hbs.service;

import com.mua.hbs.model.LoginCredential;
import com.mua.hbs.model.User;
import com.mua.hbs.repository.LoginCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private LoginCredentialRepository loginCredentialRepository;

    public Boolean join(LoginCredential loginCredential){
        try{
            User user = new User();
            loginCredential.setUser(user);
            user.setLoginCredential(loginCredential);
            loginCredentialRepository.save(loginCredential);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
