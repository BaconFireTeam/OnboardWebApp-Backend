package com.baconfire.onboardwebapp.restful.domain.SubmitForm;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PersonRequest {
    private String firstname;
    private String lastname;
    private String middlename;
    private String email;
    private String cellphone;
    private String alternatephone;
    private String gender;
    private String ssn;
    private String dob;

    private VisaRequest visa;
    private DriverLicenseRequest driverLicense;
    private List<AddressRequest> addressList;
    private ReferenceRequest reference;
    private List<ContactRequest> emergencyContactList;
}
