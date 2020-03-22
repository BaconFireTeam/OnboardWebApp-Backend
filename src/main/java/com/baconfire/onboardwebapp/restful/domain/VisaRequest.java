package com.baconfire.onboardwebapp.restful.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class VisaRequest {
    private String type;
    private String startDate;
    private String endDate;
}
