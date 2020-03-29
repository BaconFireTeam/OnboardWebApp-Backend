package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.domain.Contact;
import com.baconfire.onboardwebapp.domain.Employee;
import com.baconfire.onboardwebapp.domain.House;
import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import com.baconfire.onboardwebapp.restful.domain.*;
import com.baconfire.onboardwebapp.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class HouseHRController {
    private HouseService houseService;

    @Autowired
    public void setHouseService(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/house")
    public ListHouseResponse listHouseResponse() {
        ListHouseResponse response = new ListHouseResponse();
        response.setList(houseService.getHouse());
        response.setServiceStatus(new ServiceStatus(">9000", true, "came from spring"));
        return response;
    }

    @PostMapping("/housedetail")
    public HouseHRResponse house(@RequestBody HouseHRRequest houseReq) {

        Integer houseID = houseReq.getHouseID();


        HouseHRResponse response = new HouseHRResponse();
        response.setContact(houseService.contact(houseID));
        response.setHouse(houseService.findHouse(houseID));
        response.setList(houseService.getRoommates(houseID));
        response.setFacilities(houseService.getFacilities(houseID));
        response.setServiceStatus(new ServiceStatus(">9000", true, "came from spring"));
        return response;
    }

    @PostMapping("/report")
    public FacilityReportResponse report(@RequestBody HouseHRRequest houseReq) {
        Integer houseID = houseReq.getHouseID();
        FacilityReportResponse reportResponse = new FacilityReportResponse();
        reportResponse.setReports(houseService.getAllReport(houseID));
        return reportResponse;
    }

    @PostMapping("/reportdetail")
    public FacilityReportDetailResponse detailResponse(@RequestBody ReportDetailRequest detailRequest) {
        Integer reportID = detailRequest.getReportID();
        FacilityReportDetailResponse detailResponse = new FacilityReportDetailResponse();
        detailResponse.setReportDetails(houseService.getReportDetail(reportID));
        return detailResponse;
    }

    @PostMapping("/addcomment")
    public CommentResponse commentResponse(@RequestBody CommentRequest commentRequest){

        CommentResponse commentResponse = new CommentResponse();
        houseService.storeComment(commentRequest.getEmployeeID(), commentRequest.getReportID(), commentRequest.getComment(), commentRequest.getCreatedDate());

        return commentResponse;
    }

    @PostMapping("/changeStatus")
    public CommentResponse commentResponse(@RequestBody ReportDetailRequest reportDetailRequest){

        CommentResponse commentResponse = new CommentResponse();
        houseService.changeStatus(reportDetailRequest.getReportID());
        return commentResponse;
    }
}

