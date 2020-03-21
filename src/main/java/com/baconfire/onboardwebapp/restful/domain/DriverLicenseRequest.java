package com.baconfire.onboardwebapp.restful.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DriverLicenseRequest {
    private String car;
    private String licenseNum;
    private String expirationDate;
}
