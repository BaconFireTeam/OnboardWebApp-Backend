package com.baconfire.onboardwebapp.restful.domain;


import com.baconfire.onboardwebapp.domain.Employee;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class VisaStatusResponse {

    private Employee employee;
    private String message;
    private boolean needAlert;
    private List<VisaStatusResponse> statusList;
}
