package com.baconfire.onboardwebapp.dao.House.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.House.HouseDAO;
import com.baconfire.onboardwebapp.domain.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class HouseDAOImpl extends AbstractHibernateDAO implements HouseDAO {
    public HouseDAOImpl() {
    }

    @Override
    public Integer getHouseID(Integer employeeID) {
        String hql = "FROM Employee WHERE id = :employeeID";
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
        String hql = "FROM Contact WHERE id = :contactID";
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

    @Override
    public void storeComment(Integer employeeID, Integer reportID, String comment, String createdDate){
        Date date = new Date();
        String strDateFormat = "MM/dd/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);

        FacilityReportDetail detail = new FacilityReportDetail();
        detail.setEmployeeID(employeeID);
        detail.setComments(comment);
        detail.setCreatedDate(createdDate);
        detail.setLastModificationDate(formattedDate);
        detail.setReportID(reportID);

        Session session = getCurrentSession();
        session.save(detail);

//        String hql = "INSERT INTO FacilityReportDetail(reportID,employeeID,comment,createdDate,formattedDate)";
//        Session session = getCurrentSession();
//        Query query = session.createQuery(hql);
    }

    private  void change(String status, Integer reportID){
        if (status.equals("Open")){
            String hql = "UPDATE FacilityReport set status = :status"+" WHERE id=:reportID";
            Session session = getCurrentSession();
            Query query = session.createQuery(hql);
            query.setParameter("reportID", reportID);
            query.setParameter("status", "Closed");
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
        }
        else{
            String hql = "UPDATE FacilityReport set status = :status"+" WHERE id=:reportID";
            Session session = getCurrentSession();
            Query query = session.createQuery(hql);
            query.setParameter("reportID", reportID);
            query.setParameter("status", "Open");
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
        }
    }

    @Override
    public void changeStatus(Integer reportID){
        String hql = "FROM FacilityReport WHERE id = :reportID";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("reportID", reportID);
        try {
            FacilityReport report =(FacilityReport)query.getSingleResult();
            String status = report.getStatus();
            change(status,reportID);

        } catch (NoResultException e) {
            return;
        }

    }

    @Override
    public void storeReport(String title, Integer employeeID, String description){
        Date date = new Date();
        String strDateFormat = "MM/dd/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);

        FacilityReport report = new FacilityReport();
        report.setReportDate(formattedDate);
        report.setTitle(title);
        report.setDescription(description);
        report.setEmployeeID(employeeID);
        report.setStatus("Open");


        Session session = getCurrentSession();
        session.save(report);

//        String hql = "INSERT INTO FacilityReportDetail(reportID,employeeID,comment,createdDate,formattedDate)";
//        Session session = getCurrentSession();
//        Query query = session.createQuery(hql);
    }



}
