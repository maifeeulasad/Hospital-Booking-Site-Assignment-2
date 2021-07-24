package com.mua.hbs.service;

import com.mua.hbs.model.User;
import com.mua.hbs.model.UserPrincipal;
import com.mua.hbs.model.UserType;
import com.mua.hbs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Boolean isAdmin(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()) {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            List<User> users = userRepository.findByLoginCredentialUsername(userPrincipal.getUsername());
            User user = users.get(0);
            return user.getUserType()== UserType.ADMIN;
        }
        return false;
    }

}
