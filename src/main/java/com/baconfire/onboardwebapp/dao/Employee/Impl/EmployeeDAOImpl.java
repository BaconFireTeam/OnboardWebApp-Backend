package com.baconfire.onboardwebapp.dao.Employee.Impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.domain.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl extends AbstractHibernateDAO<Employee> implements EmployeeDAO {
    public EmployeeDAOImpl() {
        setClazz(Employee.class);
    }

    @Override
    public int saveEmployee(Employee employee) {
        Employee e = (Employee) getCurrentSession().merge(employee);
        return e.getId();
    }

    @Override
    public Employee getEmployeeByID(int employeeID) {
        return findById(employeeID);
    }
}
