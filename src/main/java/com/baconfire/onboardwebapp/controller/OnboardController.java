package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.domain.User;
import com.baconfire.onboardwebapp.service.impl.OnboardServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OnboardController {

    private OnboardServiceImpl onboardService;

    @PostMapping("/login")
    public User login(String username, String password) {
        return onboardService.login(username, password);
    }


    public void tokenLogin(String email, String token){
        //sign in with token proceed to registration
    }

    public void register(String username, String password){
        //check if username is unique
        //only go to onboarding if username is unique
        //create user using email from token
        //idk how person id will work maybe remove not null constraints?
    }
}
