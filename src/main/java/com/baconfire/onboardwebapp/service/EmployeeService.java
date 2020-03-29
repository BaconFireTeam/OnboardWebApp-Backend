package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.domain.Employee;

public interface EmployeeService {
    String getNameByID(int id);

    Employee getEmployeeByID(int employeeID);
}
