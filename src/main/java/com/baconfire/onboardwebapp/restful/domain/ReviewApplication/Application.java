package com.baconfire.onboardwebapp.restful.domain.ReviewApplication;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Application {
    private int employeeID;
    private String employeeName;
    private String type;
    private String status;
}
