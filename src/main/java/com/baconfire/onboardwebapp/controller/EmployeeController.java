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

    @PostMapping(value = "/application-open", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApplicationResponse openApplication(@RequestBody VisaStatusRequest vsr) {
        System.out.println("opening application");
        ApplicationResponse applicationResponse = new ApplicationResponse();
        applicationResponse.setOpenOrPending(true);
        applicationResponse.setApplicationWorkFlow(applicationServiceImpl.openApplication(vsr.getEmployeeId()));
        return applicationResponse;
    }

    @PostMapping(value = "/application-submit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApplicationResponse submitApplication(@RequestParam("applicationId") int appId) {
        ApplicationResponse applicationResponse = new ApplicationResponse();
        applicationResponse.setOpenOrPending(true);
        ApplicationWorkFlow applicationWorkFlow = applicationServiceImpl.updateApplication(appId, "pending");
        applicationResponse.setApplicationWorkFlow(applicationWorkFlow);
        return applicationResponse;
    }
}
