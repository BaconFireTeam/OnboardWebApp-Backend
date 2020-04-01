package com.baconfire.onboardwebapp.service.ReviewApplication;

public interface ApplicationWorkFlowService {
    void updateComment(int employeeID, String comment);

    void updateStatus(int appID, String status);

    String getComment(int employeeID);
}
