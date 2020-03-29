package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.House.HouseDAO;
import com.baconfire.onboardwebapp.domain.*;
import com.baconfire.onboardwebapp.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;


import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {


    private HouseDAO houseDaoImpl;

    @Autowired
    public void setHouseDaoImpl(HouseDAO houseDaoImpl) {
        this.houseDaoImpl = houseDaoImpl;
    }

    @Override
    @Transactional
    public House findHouse(Integer houseID) {
        return houseDaoImpl.findHouse(houseID);
    }

    @Override
    @Transactional
    public Integer getHouseID(Integer employeeID) {
        return houseDaoImpl.getHouseID(employeeID);
    }

    @Override
    @Transactional
    public List<Employee> getRoommates(Integer houseID) {
        return houseDaoImpl.getRoommates(houseID);
    }

    @Override
    @Transactional
    public Contact contact(Integer contactID) {
        return houseDaoImpl.contact(contactID);
    }

    @Override
    @Transactional
    public List<Facility> getFacilities(Integer houseID) {
        return houseDaoImpl.getFacilities(houseID);
    }

    @Override
    @Transactional
    public List<House> getHouse() {
        List<House> houseList = houseDaoImpl.getHouse();
        houseList.forEach(house -> house.getFacilityList().size());
        return houseList;
    }

    @Override
    @Transactional
    public List<FacilityReport> getFacilityReport(Integer employeeID) {
        return houseDaoImpl.getFacilityReport(employeeID);
    }

    @Override
    @Transactional
    public List<FacilityReportDetail> getReportDetail(Integer ReportID) {
        return houseDaoImpl.getReportDetail(ReportID);
    }

    @Override
    @Transactional
    public List<FacilityReport> getAllReport(Integer houseID) {
        List<Employee> employees = houseDaoImpl.getRoommates(houseID);
        List<Integer> employeeList = employees.stream().map(Employee -> Employee.getId()).collect(Collectors.toList());
        //List<Integer> employeeList = Lambda.extract(employees, Lambda.on(Employee.class).getID);
        //List<Entity> entities = getEntities();
        //List<Integer> listIntegerEntities = Lambda.extract(entities, Lambda.on(Entity.class).getFielf1());
        //List<String> field1List = entities.stream().map(urEntity -> urEntity.getField1()).collect(Collectors.toList());
        return houseDaoImpl.getAllReport(employeeList);
    }

    @Override
    @Transactional
    public void storeComment(Integer employeeID, Integer reportID, String comment, String createdDate){
        houseDaoImpl.storeComment(employeeID, reportID, comment, createdDate);
        return;
    }

    @Override
    @Transactional
    public void storeReport(String title, Integer employeeID, String description){
        houseDaoImpl.storeReport(title, employeeID, description);
        return;
    }

    @Override
    @Transactional
    public void changeStatus(Integer reportID){
        houseDaoImpl.changeStatus(reportID);
        return;
    }

}

