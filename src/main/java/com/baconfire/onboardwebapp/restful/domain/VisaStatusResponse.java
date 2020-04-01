package com.baconfire.onboardwebapp.restful.domain;


import com.baconfire.onboardwebapp.domain.Employee;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class VisaStatusResponse {

    @ApiModelProperty(notes = "Employee Object")
    private Employee employee;

    @ApiModelProperty(notes = "alert message")
    private String message;

    @ApiModelProperty(notes = "True if less than 100 days to visa expiration")
    private boolean needAlert;

    @ApiModelProperty(notes= "list of VisaStatus for HR")
    private List<VisaStatusResponse> statusList;
}
