package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.restful.domain.SubmitForm.AddressRequest;
import com.baconfire.onboardwebapp.restful.domain.SubmitForm.PersonRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ReportRequest {
    private String title;
    private Integer employeeID;
    private String description;

}