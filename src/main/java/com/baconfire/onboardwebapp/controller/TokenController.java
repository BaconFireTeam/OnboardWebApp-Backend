package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import com.baconfire.onboardwebapp.restful.domain.Response;
import com.baconfire.onboardwebapp.restful.domain.TokenRequest;
import com.baconfire.onboardwebapp.service.TokenRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class TokenController {
    private TokenRegisterService tokenRegisterService;

    @Autowired
    public void setTokenRegisterService(TokenRegisterService tokenRegisterService) {
        this.tokenRegisterService = tokenRegisterService;
    }

    @PostMapping("/token")
    public Response checkToken(@RequestBody TokenRequest tokenRequest) {
        Response response = new Response();
        String token = String.valueOf(tokenRequest.getToken());
        String email = String.valueOf(tokenRequest.getEmail());
        System.out.println(token + ", " + email);
        prepareResponse(response, true, "Token or Email is invalid");
//        boolean valid = tokenRegisterService.checkToken(token, email);

        /*
        if (valid) {
            prepareResponse(response, true, "");
        } else {
            prepareResponse(response, false, "Token or Email is invalid");
        }

         */
        return  response;
    }

    private void prepareResponse(Response response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }
}
