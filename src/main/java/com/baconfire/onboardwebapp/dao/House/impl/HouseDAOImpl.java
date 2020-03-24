package com.baconfire.onboardwebapp.dao.House.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.House.HouseDAO;
import com.baconfire.onboardwebapp.domain.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class HouseDAOImpl extends AbstractHibernateDAO implements HouseDAO {
    public HouseDAOImpl() {
    }

    @Override
    public Integer getHouseID(Integer employeeID) {
        String hql = "FROM Employee WHERE Id = :employeeID";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("employeeID", employeeID);

        try {
            Employee employee = (Employee) query.getSingleResult();
            return employee.getHouseID();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public Contact contact(Integer contactID) {
        String hql = "FROM Contact WHERE Id = :contactID";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("contactID", contactID);

        try {
            Contact contact = (Contact) query.getSingleResult();
            return contact;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public House findHouse(Integer houseID) {
        String hql = "FROM House WHERE id = :houseID";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("houseID", houseID);

        try {
            House house = (House) query.getSingleResult();
            return house;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Employee> getRoommates(Integer houseID) {
        String hql = "FROM Employee WHERE houseID = :houseID";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("houseID", houseID);
        try {
            List<Employee> roommates = query.list();
            return roommates;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Facility> getFacilities(Integer houseID) {
        String hql = "FROM Facility WHERE houseID = :houseID";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("houseID", houseID);
        try {
            List<Facility> facilities = query.list();
            return facilities;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<House> getHouse() {
        String hql = "FROM House";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        //query.setParameter("houseID", houseID);
        try {
            List<House> houses = query.list();
            return houses;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<FacilityReport> getFacilityReport(Integer employeeID) {
        String hql = "FROM FacilityReport WHERE EmployeeID = : employeeID";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("employeeID", employeeID);
        try {
            List<FacilityReport> reports = query.list();
            return reports;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<FacilityReportDetail> getReportDetail(Integer reportID){
        String hql = "FROM FacilityReportDetail WHERE reportID = : reportID";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("reportID", reportID);
        try {
            List<FacilityReportDetail> details = query.list();
            return details;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<FacilityReport> getAllReport(List<Integer> employeeList){
        String hql = "FROM FacilityReport WHERE EmployeeID IN (:employeeID)";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("employeeID", employeeList);
        try {
            List<FacilityReport> all = query.list();
            return all;
        } catch (NoResultException e) {
            return null;
        }
    }



}
