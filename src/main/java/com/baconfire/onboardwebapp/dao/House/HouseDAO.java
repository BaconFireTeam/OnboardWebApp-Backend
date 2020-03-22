package com.baconfire.onboardwebapp.dao.House;

import com.baconfire.onboardwebapp.domain.*;

import java.util.List;

public interface HouseDAO {
    Integer getHouseID (Integer EmployeeID);
    House findHouse(Integer houseID);
    Contact contact(Integer ContactID);
    List<Employee> getRoommates(Integer houseID);
    List<Facility> getFacilities(Integer houseID);
    List<House> getHouse();
    List<FacilityReport> getFacilityReport(Integer EmployeeID);
    List<FacilityReportDetail> getReportDetail(Integer ReportID);
    List<FacilityReport> getAllReport(List<Integer> employeeList);




}
