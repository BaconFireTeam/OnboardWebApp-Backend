package com.baconfire.onboardwebapp.restful.domain.ReviewApplication;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ContactResponse {
    private String firstname;
    private String lastname;
    private String middlename;
    private String email;
    private String cellphone;
    private String alternatephone;
    private String gender;
    private String relationship;
}
