package com.baconfire.onboardwebapp.controller;


import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;
import com.baconfire.onboardwebapp.restful.domain.ApplicationResponse;
import com.baconfire.onboardwebapp.restful.domain.VisaStatusRequest;
import com.baconfire.onboardwebapp.restful.domain.VisaStatusResponse;
import com.baconfire.onboardwebapp.service.ApplicationService;
import com.baconfire.onboardwebapp.service.VisaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private VisaStatusService visaStatusService;
    private ApplicationService applicationServiceImpl;

    @Autowired
    public void setVisaStatusService(VisaStatusService visaStatusService) {
        this.visaStatusService = visaStatusService;
    }

    @Autowired
    public void setApplicationServiceImpl(ApplicationService applicationServiceImpl) {
        this.applicationServiceImpl = applicationServiceImpl;
    }

    @PostMapping(value = "/visa-status", consumes = MediaType.APPLICATION_JSON_VALUE)
    public VisaStatusResponse getVisaStatus(@RequestBody VisaStatusRequest vsr) throws ParseException {
        VisaStatusResponse visaStatusResponse = visaStatusService.checkStatus(vsr.getEmployeeId());
        return visaStatusResponse;
    }

    @PostMapping(value = "/application", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApplicationResponse checkApplication(@RequestBody VisaStatusRequest vsr) {
        ApplicationResponse applicationResponse = applicationServiceImpl.checkApplicationsById(vsr.getEmployeeId());
        return applicationResponse; //need to send response check if open or pending
    }

    @PostMapping(value = "/application/open", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApplicationWorkFlow openApplication(int employeeId) {
        ApplicationWorkFlow applicationWorkFlow = new ApplicationWorkFlow();
        applicationWorkFlow.setEmployeeID(employeeId);
        applicationWorkFlow.setStatus("open");
return applicationWorkFlow;
    }

    @PostMapping(value = "/application/submit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void submitApplication() {

    }
}
