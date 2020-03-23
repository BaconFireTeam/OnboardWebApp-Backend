package com.baconfire.onboardwebapp.dao.Employee;

import com.baconfire.onboardwebapp.domain.Employee;

import java.util.List;

public interface EmployeeDAO {

    int saveEmployee(Employee employee);

    Employee getEmployeeByID(int employeeID);

    List<Employee> getAllEmployees();
}
