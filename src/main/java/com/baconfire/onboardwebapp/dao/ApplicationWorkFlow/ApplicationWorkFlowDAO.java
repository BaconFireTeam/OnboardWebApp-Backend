package com.baconfire.onboardwebapp.dao.ApplicationWorkFlow;

import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;

public interface ApplicationWorkFlowDAO {

    ApplicationWorkFlow checkOpen(int employeeId);

    ApplicationWorkFlow checkPending(int employeeId);
}
