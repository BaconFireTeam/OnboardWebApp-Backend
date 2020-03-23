package com.baconfire.onboardwebapp.restful.domain.SubmitForm;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddressRequest {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String stateName;
    private String stateAbbr;
}
