package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;
import com.baconfire.onboardwebapp.restful.domain.ApplicationResponse;

import java.util.List;

public interface ApplicationService {

    ApplicationResponse checkApplicationsById(int employeeId);

    List<ApplicationResponse> checkAllApplications();

    ApplicationWorkFlow updateApplication(int id, String status);

    ApplicationWorkFlow openApplication(int id);

    void updateOnboardingApplication(int id, String status);

    List<ApplicationWorkFlow> getApplicationByStatus(String status);

    List<ApplicationWorkFlow> getOnboardingApplication();

    void updateComment(int employeeID, String comment);
}
