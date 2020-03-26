package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.ApplicationWorkFlow.ApplicationWorkFlowDAO;
import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;
import com.baconfire.onboardwebapp.domain.Employee;
import com.baconfire.onboardwebapp.restful.domain.ApplicationResponse;
import com.baconfire.onboardwebapp.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationWorkFlowDAO applicationWorkFlowDAOImpl;
    private EmployeeDAO employeeDAOImpl;

    @Autowired
    public void setApplicationWorkFlowDAOImpl(ApplicationWorkFlowDAO applicationWorkFlowDAOImpl) {
        this.applicationWorkFlowDAOImpl = applicationWorkFlowDAOImpl;
    }

    @Autowired
    public void setEmployeeDAOImpl(EmployeeDAO employeeDAOImpl) {
        this.employeeDAOImpl = employeeDAOImpl;
    }

    @Override
    @Transactional
    public ApplicationResponse checkApplicationsById(int employeeId) {
        Employee employee = employeeDAOImpl.getEmployeeByID(employeeId);
        ApplicationResponse applicationResponse = new ApplicationResponse();
        applicationResponse.setEmployee(employee);
        ApplicationWorkFlow applicationWorkFlow = applicationWorkFlowDAOImpl.checkOpen(employeeId);
        if(applicationWorkFlow == null) {
            applicationWorkFlow = applicationWorkFlowDAOImpl.checkPending(employeeId);
        }
        applicationResponse.setApplicationWorkFlow(applicationWorkFlow);
        if (applicationWorkFlow == null) {
            applicationResponse.setOpenOrPending(false);
        } else {
            applicationResponse.setOpenOrPending(true);
        }
        return applicationResponse;
    }

    @Override
    @Transactional
    public List<ApplicationResponse> checkAllApplications() {
        List<ApplicationResponse> applicationList = new ArrayList<>();
        List<Employee> employeeList = employeeDAOImpl.getAllEmployees();
        for(int i = 0; i < employeeList.size(); i++) {
            applicationList.add(checkApplicationsById(employeeList.get(i).getId()));
        }
        return applicationList;
    }

    @Override
    @Transactional
    public ApplicationWorkFlow updateApplication(int id, String status) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        ApplicationWorkFlow applicationWorkFlow = applicationWorkFlowDAOImpl.getById(id);
        applicationWorkFlow.setModificationDate(formatter.format(now));
        applicationWorkFlow.setStatus(status);
        applicationWorkFlowDAOImpl.updateApplication(applicationWorkFlow);
        return applicationWorkFlow;
    }

    @Override
    @Transactional
    public ApplicationWorkFlow openApplication(int id) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        ApplicationWorkFlow applicationWorkFlow = new ApplicationWorkFlow();
        applicationWorkFlow.setEmployeeID(id);
        applicationWorkFlow.setStatus("open");
        applicationWorkFlow.setCreatedDate(formatter.format(now));
        applicationWorkFlow.setType("OPT");
        applicationWorkFlowDAOImpl.updateApplication(applicationWorkFlow);
        return applicationWorkFlow;
    }

    @Override
    @Transactional
    public void updateOnboardingApplication(int id, String status) {
        ApplicationWorkFlow applicationWorkFlow = new ApplicationWorkFlow();
        applicationWorkFlow.setEmployeeID(id);

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        Date createDate = new Date();
        applicationWorkFlow.setCreatedDate(formatter.format(createDate));

        applicationWorkFlow.setStatus(status);
        applicationWorkFlow.setType("Onboarding");
        this.applicationWorkFlowDAOImpl.updateApplication(applicationWorkFlow);
    }
}
