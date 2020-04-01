package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.restful.domain.SubmitForm.AddressRequest;
import com.baconfire.onboardwebapp.restful.domain.SubmitForm.PersonRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ApplicationRequest {

    @ApiModelProperty(notes = "application id number", required = true)
    private int applicationId;

    @ApiModelProperty(notes = "not sure didn't write this -Edward")
    private PersonRequest person;

    @ApiModelProperty(notes = "not sure didn't write this -Edward")
    private AddressRequest address;
}
