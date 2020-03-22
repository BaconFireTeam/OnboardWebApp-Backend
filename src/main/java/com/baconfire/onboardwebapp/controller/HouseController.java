package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.domain.*;
import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import com.baconfire.onboardwebapp.restful.domain.*;
import com.baconfire.onboardwebapp.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class HouseController {
    private HouseService houseService;

    @Autowired
    public void setHouseService(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping("/housedetail")
    public HouseResponse house(@RequestBody HouseRequest houseReq) {

        Integer employeeID = houseReq.getEmployeeID();
        Integer houseID = houseService.getHouseID(employeeID);

        HouseResponse response = new HouseResponse();
        response.setContact(houseService.contact(houseID));
        response.setHouse(houseService.findHouse(houseID));
        response.setList(houseService.getRoommates(houseID));
        response.setServiceStatus(new ServiceStatus(">9000", true, "came from spring"));
        return response;
    }

    @PostMapping("/report")
    public FacilityReportResponse report(@RequestBody HouseRequest houseRequest){
        Integer employeeID = houseRequest.getEmployeeID();
        FacilityReportResponse reportResponse = new FacilityReportResponse();
        reportResponse.setReports(houseService.getFacilityReport(employeeID));
        return reportResponse;
    }

    @PostMapping("/reportdetail")
    public FacilityReportDetailResponse detailResponse(@RequestBody ReportDetailRequest detailRequest){
        Integer reportID = detailRequest.getReportID();
        FacilityReportDetailResponse detailResponse = new FacilityReportDetailResponse();
        detailResponse.setReportDetails(houseService.getReportDetail(reportID));
        return detailResponse;
    }

}
