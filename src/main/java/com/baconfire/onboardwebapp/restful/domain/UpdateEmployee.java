package com.baconfire.onboardwebapp.restful.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployee {
    private int employeeId;
    private String newExpDate;
}
