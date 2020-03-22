package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.restful.domain.VisaStatusRequest;
import com.baconfire.onboardwebapp.restful.domain.VisaStatusResponse;
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

    @Autowired
    public void setVisaStatusService(VisaStatusService visaStatusService) {
        this.visaStatusService = visaStatusService;
    }

    @GetMapping(value = "/visa-status", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<VisaStatusResponse> getVisaStatus() throws ParseException {
        List<VisaStatusResponse> visaList = visaStatusService.checkAllStatus();
        return visaList;
    }
}
