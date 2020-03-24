package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import com.baconfire.onboardwebapp.restful.domain.Response;
//import com.baconfire.onboardwebapp.restful.domain.TokenRequest;
import com.baconfire.onboardwebapp.restful.domain.TokenRequest;
import com.baconfire.onboardwebapp.restful.domain.UserRequest;
import com.baconfire.onboardwebapp.service.TokenRegisterService;
import com.baconfire.onboardwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class TokenController {
    private TokenRegisterService tokenRegisterServiceImpl;
    private UserService userServiceImpl;

    @Autowired
    public void setTokenRegisterService(TokenRegisterService tokenRegisterServiceImpl) {
        this.tokenRegisterServiceImpl = tokenRegisterServiceImpl;
    }

    @Autowired
    public void setUserServiceImpl(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/token")
    public Response checkToken(@RequestBody TokenRequest tokenRequest) {
        Response response = new Response();
        String token = String.valueOf(tokenRequest.getToken());
        String email = String.valueOf(tokenRequest.getEmail());

        boolean valid = this.tokenRegisterServiceImpl.checkToken(token, email);
        prepareResponse(response, valid, "token and email doesn't match");

        return  response;
    }

    @PostMapping("/setup")
    public Response register(@RequestBody UserRequest userRequest) {
        Response response = new Response();

        boolean uniqueUsername = this.userServiceImpl.registerUser(userRequest);

        prepareResponse(response, uniqueUsername, "username has exist");

        return response;
    }

    private void prepareResponse(Response response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, success ? "" : errorMessage));
    }
}
