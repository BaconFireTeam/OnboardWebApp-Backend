package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.domain.Employee;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeProfileResponse {

    private List<Employee> employeeList;
    private int length;

}
