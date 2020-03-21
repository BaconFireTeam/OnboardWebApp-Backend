package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.domain.Contact;
import com.baconfire.onboardwebapp.restful.domain.*;
import com.baconfire.onboardwebapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OnboardApplicationController {
    private PersonService personServiceImpl;

    @Autowired
    public void setPersonServiceImpl(PersonService personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @PostMapping("/onboard-application")
    public Response submitApplication(@RequestBody EmployeeRequest personRequest) {
        Response response = new Response();
//        this.personServiceImpl.savePersonInfo(personRequest);
//        System.out.println(applicationRequest.getPerson().toString());
//        System.out.println(applicationRequest.getAddress().toString());
        System.out.println(personRequest.toString());
        return response;
    }
}
