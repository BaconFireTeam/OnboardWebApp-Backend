package com.baconfire.onboardwebapp.dao.Employee.Impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.domain.Employee;
import net.bytebuddy.description.type.TypeList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class EmployeeDAOImpl extends AbstractHibernateDAO<Employee> implements EmployeeDAO {
    public EmployeeDAOImpl() {
        setClazz(Employee.class);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String hql = "FROM Employee";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        try {
            List employee = (List<Employee>) query.getResultList();
            return employee;
        } catch(NoResultException e) {
            return null;
        }
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
