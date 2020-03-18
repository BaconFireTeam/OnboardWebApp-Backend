package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.domain.User;
import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import com.baconfire.onboardwebapp.restful.domain.Response;
import com.baconfire.onboardwebapp.restful.domain.UserRequest;
import com.baconfire.onboardwebapp.service.OnboardService;
import com.baconfire.onboardwebapp.service.impl.OnboardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class OnboardController {
    private OnboardService onboardService;

    @Autowired
    public void setOnboardService(OnboardService onboardService) {
        this.onboardService = onboardService;
    }

    @PostMapping("/login")
    public Response login(@RequestBody UserRequest userReq) {
        Response response = new Response();
        String username = userReq.getUsername();
        String password = userReq.getPassword();
        User user = onboardService.login(username, password);
        response.setUser(user);
        response.setServiceStatus(new ServiceStatus(">9000", true, "came from spring"));
        return response;
    }

    public void newUser(@RequestBody User user){
        //for register user
        //onboardService.newUser(user);
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
