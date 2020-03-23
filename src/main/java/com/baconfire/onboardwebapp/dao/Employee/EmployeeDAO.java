package com.baconfire.onboardwebapp.dao.Employee;

import com.baconfire.onboardwebapp.domain.Employee;

public interface EmployeeDAO {
    int saveEmployee(Employee employee);

    Employee getEmployeeByID(int employeeID);
}
