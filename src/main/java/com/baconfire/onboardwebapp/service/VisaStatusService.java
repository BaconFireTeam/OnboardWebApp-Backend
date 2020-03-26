package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.domain.VisaStatus;
import com.baconfire.onboardwebapp.restful.domain.VisaStatusResponse;

import java.text.ParseException;
import java.util.List;

public interface VisaStatusService {

    VisaStatusResponse checkStatus(int employeeId) throws ParseException;

    List<VisaStatusResponse> checkAllStatus() throws ParseException;

    void updateVisaStatus(int employeeId, String newExpDate) throws ParseException;
}
