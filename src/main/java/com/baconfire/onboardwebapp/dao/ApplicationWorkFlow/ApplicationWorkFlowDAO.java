package com.baconfire.onboardwebapp.dao.ApplicationWorkFlow;

import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;

import java.util.List;

public interface ApplicationWorkFlowDAO {

    ApplicationWorkFlow getById(int id);

    void updateApplication(ApplicationWorkFlow applicationWorkFlow);

    ApplicationWorkFlow checkOpen(int employeeId);

    ApplicationWorkFlow checkPending(int employeeId);

    List<ApplicationWorkFlow> getApplicationByStatus(String status);

    List<ApplicationWorkFlow> getOnboardingApplication();

    void updateComment(int employeeID, String comment);

    String getComment(int employeeID);
}
