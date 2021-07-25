package com.mua.hbs.controller;

import com.mua.hbs.model.LoginCredential;
import com.mua.hbs.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/signup")
    public Boolean join(@RequestBody LoginCredential loginCredential){
        return service.join(loginCredential);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginCredential loginCredential){
        return service.login(loginCredential);
    }

    @GetMapping("/check")
    public Boolean check(){
        return service.check();
    }

}
