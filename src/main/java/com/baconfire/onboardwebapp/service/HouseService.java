package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.domain.*;

import java.util.List;

public interface HouseService {

    public Integer getHouseID (Integer EmployeeID);
    public House findHouse(Integer houseID);
    public Contact contact(Integer ContactID);
    public List<Employee> getRoommates(Integer houseID);
    public List<Facility> getFacilities(Integer houseID);
    public List<House> getHouse();
    public List<FacilityReport> getFacilityReport(Integer EmployeeID);
    public List<FacilityReportDetail> getReportDetail(Integer ReportID);
    public List<FacilityReport> getAllReport(Integer houseID);
    public void storeComment(Integer employeeID, Integer reportID, String comment, String createdDate);
    public void storeReport(String title, Integer employeeID, String description);
    public void changeStatus(Integer reportID);
}
