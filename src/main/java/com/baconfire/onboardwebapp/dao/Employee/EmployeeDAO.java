package com.baconfire.onboardwebapp.dao.Employee;

import com.baconfire.onboardwebapp.domain.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);
}
