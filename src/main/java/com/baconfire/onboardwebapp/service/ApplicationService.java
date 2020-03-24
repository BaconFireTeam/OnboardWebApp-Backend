package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;
import com.baconfire.onboardwebapp.restful.domain.ApplicationResponse;

import java.util.List;

public interface ApplicationService {

    ApplicationResponse checkApplicationsById(int employeeId);

    List<ApplicationResponse> checkAllApplications();

    ApplicationWorkFlow updateApplication(int id, String status);

    ApplicationWorkFlow openApplication(int id);
}
