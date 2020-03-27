package com.baconfire.onboardwebapp.service.ReviewApplication.Impl;

import com.baconfire.onboardwebapp.dao.ApplicationWorkFlow.ApplicationWorkFlowDAO;
import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;
import com.baconfire.onboardwebapp.service.ReviewApplication.ApplicationWorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationWorkFlowServiceImpl implements ApplicationWorkFlowService {
    private ApplicationWorkFlowDAO applicationWorkFlowDAOImpl;

    @Autowired
    public void setApplicationWorkFlowDAOImpl(ApplicationWorkFlowDAO applicationWorkFlowDAOImpl) {
        this.applicationWorkFlowDAOImpl = applicationWorkFlowDAOImpl;
    }

    @Override
    @Transactional
    public void updateComment(int employeeID, String comment) {
        this.applicationWorkFlowDAOImpl.updateComment(employeeID, comment);
    }
}
