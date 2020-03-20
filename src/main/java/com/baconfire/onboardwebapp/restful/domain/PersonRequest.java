package com.baconfire.onboardwebapp.restful.domain;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PersonRequest {
    private int id;
    private String firstname;
    private String lastname;
    private String middlename;
    private String email;
    private String cellphone;
    private String alternatephone;
    private String gender;
    private String ssn;
    private String dob;

    private AddressRequest address;
}
