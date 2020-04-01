package com.baconfire.onboardwebapp.restful.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class VisaStatusRequest {

    @ApiModelProperty(notes="EmployeeID", required = true)
    private int employeeId;
}
