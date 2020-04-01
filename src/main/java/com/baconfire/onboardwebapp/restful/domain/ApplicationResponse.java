package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;
import com.baconfire.onboardwebapp.domain.Employee;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ApplicationResponse {

    @ApiModelProperty(notes = "Employee Object")
    private Employee employee;

    @ApiModelProperty(notes = "Application Object")
    private ApplicationWorkFlow applicationWorkFlow;

    @ApiModelProperty(notes = "applciation status")
    private boolean openOrPending;

    @ApiModelProperty(notes = "list of applications for HR")
    private List<ApplicationResponse> applicationList;
}
