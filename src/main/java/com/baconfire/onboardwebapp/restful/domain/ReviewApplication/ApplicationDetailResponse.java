package com.baconfire.onboardwebapp.restful.domain.ReviewApplication;

import com.baconfire.onboardwebapp.restful.domain.Files.UploadFileResponse;
import com.baconfire.onboardwebapp.restful.domain.SubmitForm.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ApplicationDetailResponse {
    private String firstname;
    private String lastname;
    private String middlename;
    private String email;
    private String cellphone;
    private String alternatephone;
    private String gender;
    private String ssn;
    private String dob;

    // address
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String stateName;
    private String stateAbbr;

    // driver license
    private String car;
    private String licenseNum;
    private String expirationDate;

    // visa
    private String visaType;
    private String visaStartDate;
    private String visaEndDate;

    // reference
    private String referenceEmail;

    // contact
    private List<ContactResponse> emergencyContactList;

    private List<UploadFileResponse> uploadFileResponseList;
}