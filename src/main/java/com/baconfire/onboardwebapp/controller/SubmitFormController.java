package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import com.baconfire.onboardwebapp.restful.domain.*;
import com.baconfire.onboardwebapp.restful.domain.SubmitForm.EmployeeRequest;
import com.baconfire.onboardwebapp.service.Employee.SubmitFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SubmitFormController {
    private SubmitFormService submitFormServiceImpl;

    @Autowired
    public void setSubmitFormServiceImpl(SubmitFormService submitFormServiceImpl) {
        this.submitFormServiceImpl = submitFormServiceImpl;
    }

    @PostMapping("/onboard-application")
    public Response submitApplication(@RequestBody EmployeeRequest employee) {
        System.out.println(employee.toString());
        Response response = new Response();

        boolean validForm = this.submitFormServiceImpl.submitForm(employee.getEmployee());
        prepareResponse(response, validForm, "fail to save employee");

        return response;
    }

    private void prepareResponse(Response response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, success ? "" : errorMessage));
    }
}
