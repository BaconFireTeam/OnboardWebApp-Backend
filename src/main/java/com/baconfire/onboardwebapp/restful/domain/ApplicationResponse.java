package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ApplicationResponse {
    private String employeeName;
    private ApplicationWorkFlow applicationWorkFlow;
    private boolean openOrPending;
}
