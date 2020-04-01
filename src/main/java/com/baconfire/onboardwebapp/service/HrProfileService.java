package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.domain.Employee;

import java.util.List;

public interface HrProfileService {

    List<Employee> getAllEmployees();

    List<Employee> searchEmployee(String search);
}
