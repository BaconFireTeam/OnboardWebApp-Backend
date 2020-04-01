package com.baconfire.onboardwebapp.restful.domain.ReviewApplication;

import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class OngoingApplicationResponse {
    private ServiceStatus serviceStatus;

    private List<Application> applicationList;

}
