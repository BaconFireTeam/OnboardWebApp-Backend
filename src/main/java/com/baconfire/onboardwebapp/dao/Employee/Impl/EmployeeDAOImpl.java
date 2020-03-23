package com.baconfire.onboardwebapp.dao.Employee.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
//import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.domain.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import java.util.List;

@Repository("employeeDAOImpl")
public class EmployeeDAOImpl extends AbstractHibernateDAO<Employee> implements EmployeeDAO {

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
    public Employee getEmployeeById(int id) {
        String hql = "FROM Employee WHERE id = :id";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        try {
            Employee employee = (Employee) query.getSingleResult();
            return employee;
        } catch(NoResultException e) {
            return null;
        }
    }
}
