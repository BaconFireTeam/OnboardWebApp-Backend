package com.baconfire.onboardwebapp.dao.ApplicationWorkFlow;

import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;

public interface ApplicationWorkFlowDAO {

    ApplicationWorkFlow getById(int id);

    void updateApplication(ApplicationWorkFlow applicationWorkFlow);

    ApplicationWorkFlow checkOpen(int employeeId);

    ApplicationWorkFlow checkPending(int employeeId);
}
