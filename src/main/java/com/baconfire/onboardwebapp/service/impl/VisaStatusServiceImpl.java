package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.constant.VisaStatusMessage;
import com.baconfire.onboardwebapp.dao.Employee.impl.EmployeeDAOImpl;
import com.baconfire.onboardwebapp.domain.Employee;
import com.baconfire.onboardwebapp.restful.domain.VisaStatusResponse;
import com.baconfire.onboardwebapp.service.VisaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class VisaStatusServiceImpl implements VisaStatusService, VisaStatusMessage {

    private EmployeeDAOImpl employeeDao;

    @Autowired
    public void setEmployeeDao(EmployeeDAOImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public VisaStatusResponse checkStatus(int employeeId) throws ParseException {
        VisaStatusResponse visaStatusResponse = new VisaStatusResponse();
        Employee employee = employeeDao.getEmployeeById(employeeId);
        visaStatusResponse.setEmployee(employee);
        if(employee.getVisaStatusId() > 7) { //only handles opt steps
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date now = new Date();
            Date endDate = formatter.parse(employee.getVisaEndDate());
            long diff = endDate.getTime() - now.getTime() ;
            long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println(days);
            if(days <= 100 || employee.getVisaStatusId() == 8 || employee.getVisaStatusId() == 12) {
                visaStatusResponse.setNeedAlert(true);
                if(employee.getVisaStatusId() == 8) {
                    visaStatusResponse.setMessage(NEED_OPT_EAD);
                } else if (employee.getVisaStatusId() == 9) {
                    visaStatusResponse.setMessage(NEED_I983);
                } else if (employee.getVisaStatusId() == 10) {
                    visaStatusResponse.setMessage(NEED_I20);
                } else if (employee.getVisaStatusId() == 11) {
                    visaStatusResponse.setMessage(NEED_OPT_STEM);
                } else if (employee.getVisaStatusId() == 12) {
                    visaStatusResponse.setMessage(NEED_STEM_EAD);
                }
            } else {
                visaStatusResponse.setMessage(NO_Alert);
                visaStatusResponse.setNeedAlert(false);
            }
        } else {
            visaStatusResponse.setMessage(NO_Alert);
            visaStatusResponse.setNeedAlert(false);
        }
        return visaStatusResponse;
    }

    @Override
    @Transactional
    public List<VisaStatusResponse> checkAllStatus() throws ParseException {
        List<VisaStatusResponse> visaList = new ArrayList<>();
        List<Employee> employeeList = employeeDao.getAllEmployees();
        for(int i = 0; i < employeeList.size(); i++) {
            visaList.add(checkStatus(employeeList.get(i).getId()));
        }
        return visaList;
    }
}
