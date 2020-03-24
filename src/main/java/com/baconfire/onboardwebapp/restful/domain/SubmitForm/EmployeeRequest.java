package com.baconfire.onboardwebapp.restful.domain.SubmitForm;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeRequest {
    private PersonRequest employee;
}
