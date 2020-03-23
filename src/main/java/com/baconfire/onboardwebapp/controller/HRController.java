package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.restful.domain.ApplicationResponse;
import com.baconfire.onboardwebapp.restful.domain.VisaStatusRequest;
import com.baconfire.onboardwebapp.restful.domain.VisaStatusResponse;
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

    @GetMapping(value = "/application", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ApplicationResponse> checkApplication() {
        List<ApplicationResponse> applicationList = applicationServiceImpl.checkAllApplications();
        return applicationList;
    }

    @PostMapping(value = "/application", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateApplication(int appId, String status){

    }
}
