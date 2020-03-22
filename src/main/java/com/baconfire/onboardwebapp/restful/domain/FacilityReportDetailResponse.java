package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.domain.*;
import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FacilityReportDetailResponse {
    private ServiceStatus serviceStatus;
    private List<FacilityReportDetail> reportDetails;

}