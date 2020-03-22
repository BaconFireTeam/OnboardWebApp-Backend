package com.baconfire.onboardwebapp.controller;


import com.baconfire.onboardwebapp.restful.domain.VisaStatusRequest;
import com.baconfire.onboardwebapp.restful.domain.VisaStatusResponse;
import com.baconfire.onboardwebapp.service.VisaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    VisaStatusService visaStatusService;

    @Autowired
    public void setVisaStatusService(VisaStatusService visaStatusService) {
        this.visaStatusService = visaStatusService;
    }

    @PostMapping(value = "/visa-status", consumes = MediaType.APPLICATION_JSON_VALUE)
    public VisaStatusResponse getVisaStatus(@RequestBody VisaStatusRequest vsr) throws ParseException {
        VisaStatusResponse visaStatusResponse = visaStatusService.checkStatus(vsr.getEmployeeId());
        return visaStatusResponse;
    }
}
