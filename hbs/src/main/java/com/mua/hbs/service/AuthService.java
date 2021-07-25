package com.mua.hbs.service;

import com.mua.hbs.model.LoginCredential;
import com.mua.hbs.model.User;
import com.mua.hbs.provider.JwtTokenProvider;
import com.mua.hbs.repository.LoginCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private LoginCredentialRepository loginCredentialRepository;
    @Autowired
    private JwtTokenProvider tokenProvider;

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

    public String login(LoginCredential loginCredential){
        try{
            String username=loginCredential.getUsername();
            String password=loginCredential.getPassword();
            List<LoginCredential> loginCredentialList = loginCredentialRepository.findByUsername(username);
            if(loginCredentialList.get(0).getPassword().equals(password)){
                return tokenProvider.generateToken(loginCredential.getUsername());
            }
        }catch (Exception e){
            return "";
        }
        return "";
    }

    public Boolean check(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.isAuthenticated();
    }

}
