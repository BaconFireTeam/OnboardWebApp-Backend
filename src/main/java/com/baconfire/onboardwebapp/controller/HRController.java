package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.restful.domain.*;
import com.baconfire.onboardwebapp.service.ApplicationService;
import com.baconfire.onboardwebapp.service.VisaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/hr")
public class HRController {

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

    @GetMapping(value = "/visa-status")
    public VisaStatusResponse getVisaStatus() throws ParseException {
        VisaStatusResponse visaStatusResponse = new VisaStatusResponse();
        List<VisaStatusResponse> visaList = visaStatusService.checkAllStatus();
        visaStatusResponse.setStatusList(visaList);
        return visaStatusResponse;
    }

    @GetMapping(value = "/application")
    public ApplicationResponse checkApplication() {
        ApplicationResponse applicationResponse = new ApplicationResponse();
        List<ApplicationResponse> applicationList = applicationServiceImpl.checkAllApplications();
        applicationResponse.setApplicationList(applicationList);
        return applicationResponse;
    }

    @PostMapping(value = "/application-update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApplicationResponse updateApplication(@RequestBody ApplicationUpdateRequest applicationUpdateRequest){
        applicationServiceImpl.updateApplication(applicationUpdateRequest.getApplicationId(), applicationUpdateRequest.getStatus());
        ApplicationResponse applicationResponse = new ApplicationResponse();
        List<ApplicationResponse> applicationList = applicationServiceImpl.checkAllApplications();
        applicationResponse.setApplicationList(applicationList);
        return applicationResponse;
    }

    @PostMapping(value = "/visa-update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public VisaStatusResponse updateVisaStatus(@RequestBody UpdateEmployee updateEmployee) throws ParseException {
        visaStatusService.updateVisaStatus(updateEmployee.getEmployeeId(), updateEmployee.getNewExpDate());
        VisaStatusResponse visaStatusResponse = new VisaStatusResponse();
        List<VisaStatusResponse> visaList = visaStatusService.checkAllStatus();
        visaStatusResponse.setStatusList(visaList);
        return visaStatusResponse;
    }
}
