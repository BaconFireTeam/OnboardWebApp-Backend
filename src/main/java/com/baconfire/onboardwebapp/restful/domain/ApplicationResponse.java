package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;
import com.baconfire.onboardwebapp.domain.Employee;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ApplicationResponse {
    private Employee employee;
    private ApplicationWorkFlow applicationWorkFlow;
    private boolean openOrPending;
    private List<ApplicationResponse> applicationList;
}
