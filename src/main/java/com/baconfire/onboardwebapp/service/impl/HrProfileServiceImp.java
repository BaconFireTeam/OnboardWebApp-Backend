package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.domain.Employee;
import com.baconfire.onboardwebapp.service.HrProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HrProfileServiceImp implements HrProfileService {

    private EmployeeDAO employeeDAO;

    @Autowired
    @Transactional
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public List<Employee> searchEmployee(String search) {
        List<Employee> employeeList = new ArrayList<>();
        try{
            int id = Integer.parseInt(search);
            Employee employee = employeeDAO.getEmployeeByID(id);
            if(employee != null) {
                employeeList.add(employee);
            }
            return employeeList;
        }catch (NumberFormatException ex) {
            List<Employee> employeeFirst = employeeDAO.getFirstLikeEmployees(search);
            List<Employee> employeeLast = employeeDAO.getLastLikeEmployees(search);
            for(int i = 0; i < employeeFirst.size(); i++){
                if(!employeeList.contains(employeeFirst.get(i))){
                    employeeList.add(employeeFirst.get(i));
                }
            }
            for(int i = 0; i < employeeLast.size(); i++){
                if(!employeeList.contains(employeeLast.get(i))){
                    employeeList.add(employeeLast.get(i));
                }
            }
            return employeeList;
        }
    }
}
