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
    private TokenRegisterService tokenRegisterServiceImpl;

    @Autowired
    public void setTokenRegisterService(TokenRegisterService tokenRegisterServiceImpl) {
        this.tokenRegisterServiceImpl = tokenRegisterServiceImpl;
    }

    @PostMapping("/token")
    public Response checkToken(@RequestBody TokenRequest tokenRequest) {
        Response response = new Response();
        String token = String.valueOf(tokenRequest.getToken());
        String email = String.valueOf(tokenRequest.getEmail());
//        prepareResponse(response, true, "Token or Email is invalid");
        boolean valid = tokenRegisterServiceImpl.checkToken(token, email);
        prepareResponse(response, valid, "");
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
