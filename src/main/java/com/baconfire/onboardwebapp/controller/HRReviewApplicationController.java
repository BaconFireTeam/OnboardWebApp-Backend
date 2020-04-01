package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.domain.*;
import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import com.baconfire.onboardwebapp.restful.domain.ApplicationUpdateRequest;
import com.baconfire.onboardwebapp.restful.domain.Response;
import com.baconfire.onboardwebapp.restful.domain.ReviewApplication.*;
import com.baconfire.onboardwebapp.service.ApplicationService;
import com.baconfire.onboardwebapp.service.EmployeeService;
import com.baconfire.onboardwebapp.service.FileStorage.PersonalDocumentService;
import com.baconfire.onboardwebapp.service.PersonService;
import com.baconfire.onboardwebapp.service.ReviewApplication.AddressService;
import com.baconfire.onboardwebapp.service.ReviewApplication.ApplicationWorkFlowService;
import com.baconfire.onboardwebapp.service.ReviewApplication.ContactService;
import com.baconfire.onboardwebapp.service.VisaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/hr")
public class HRReviewApplicationController {
    private ApplicationService applicationServiceImpl;

    private PersonService personServiceImpl;
    private EmployeeService employeeServiceImpl;
    private VisaStatusService visaStatusServiceImpl;
    private ContactService contactServiceImpl;
    private AddressService addressServiceImpl;

    private PersonalDocumentService personalDocumentServiceImpl;

    @Autowired
    public void setEmployeeServiceImpl(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Autowired
    public void setApplicationServiceImpl(ApplicationService applicationServiceImpl) {
        this.applicationServiceImpl = applicationServiceImpl;
    }

    @Autowired
    public void setPersonServiceImpl(PersonService personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @Autowired
    public void setVisaStatusServiceImpl(VisaStatusService visaStatusServiceImpl) {
        this.visaStatusServiceImpl = visaStatusServiceImpl;
    }

    @Autowired
    public void setContactServiceImpl(ContactService contactServiceImpl) {
        this.contactServiceImpl = contactServiceImpl;
    }

    @Autowired
    public void setAddressServiceImpl(AddressService addressServiceImpl) {
        this.addressServiceImpl = addressServiceImpl;
    }

    @Autowired
    public void setPersonalDocumentServiceImpl(PersonalDocumentService personalDocumentServiceImpl) {
        this.personalDocumentServiceImpl = personalDocumentServiceImpl;
    }

    @GetMapping("/getApplication")
    public OngoingApplicationResponse getApplication() {
        OngoingApplicationResponse response = new OngoingApplicationResponse();

        List<ApplicationWorkFlow> applicationWorkFlowList = this.applicationServiceImpl.getOnboardingApplication();

        if (applicationWorkFlowList.size() == 0) {
            response.setServiceStatus(new ServiceStatus("401", false, "No Ongoing Application found"));
            return response;
        } else {
            response.setServiceStatus(new ServiceStatus("200", true, ""));
        }

        List<Application> applicationList = new ArrayList<>();
        applicationWorkFlowList.forEach(applicationWorkFlow -> {
            int appid = applicationWorkFlow.getId();
            int id = applicationWorkFlow.getEmployeeID();
            Application application = new Application(appid, id, this.employeeServiceImpl.getNameByID(id)
                    , applicationWorkFlow.getType(), applicationWorkFlow.getStatus());

            applicationList.add(application);
        });

        response.setApplicationList(applicationList);

        return response;
    }

    @PostMapping("/saveFormComment")
    public Response saveCommentForApplication(@RequestBody CommentRequest commentRequest) {
        Response response = new Response();
        int employeeID = Integer.parseInt(commentRequest.getEmployeeID());
        String comment = commentRequest.getComment();

        this.applicationServiceImpl.updateComment(employeeID, comment);

        return response;
    }

    @PostMapping("/saveFileComment")
    public Response saveCommentForFilesApplication(@RequestBody FileCommentRequest fileCommentRequest) {
        Response response = new Response();

        fileCommentRequest.getFileCommentRequest().getCommentRequestList().forEach(commentRequest -> {
                    int fileId = commentRequest.getFileID();
                    String comment = commentRequest.getComment();

                    this.personalDocumentServiceImpl.updateComment(fileId, comment);
                });

        return response;
    }

    @PostMapping("/updateApplicationStatus")
    public Response updateApplicationStatus(@RequestBody ApplicationUpdateRequest applicationUpdateRequest) {
        Response response = new Response();

        System.out.println(applicationUpdateRequest.toString());

        int appID = applicationUpdateRequest.getApplicationId();
        String status = applicationUpdateRequest.getStatus();

        this.applicationServiceImpl.updateApplication(appID, status);

        return response;
    }
}
