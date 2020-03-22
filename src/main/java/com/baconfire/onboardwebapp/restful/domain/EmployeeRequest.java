package com.baconfire.onboardwebapp.restful.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeRequest {
    private PersonRequest employee;
}
