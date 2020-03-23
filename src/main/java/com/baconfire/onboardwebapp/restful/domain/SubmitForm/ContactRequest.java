package com.baconfire.onboardwebapp.restful.domain.SubmitForm;


import com.baconfire.onboardwebapp.restful.domain.SubmitForm.AddressRequest;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ContactRequest {
    private String firstname;
    private String lastname;
    private String middlename;
    private String email;
    private String cellphone;
    private String alternatephone;
    private String gender;

    private AddressRequest address;
    private String relationship;
}
