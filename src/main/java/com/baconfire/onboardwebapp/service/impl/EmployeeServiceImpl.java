package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.domain.Employee;
import com.baconfire.onboardwebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAOImpl;

    @Autowired
    public void setEmployeeDAOImpl(EmployeeDAO employeeDAOImpl) {
        this.employeeDAOImpl = employeeDAOImpl;
    }

    @Override
    @Transactional
    public String getNameByID(int id) {
        Employee employee = this.employeeDAOImpl.getEmployeeByID(id);
        return employee.getFirstname() + " " + employee.getLastname();
    }

    @Override
    @Transactional
    public Employee getEmployeeByID(int employeeID) {
        return this.employeeDAOImpl.getEmployeeByID(employeeID);
    }
}
