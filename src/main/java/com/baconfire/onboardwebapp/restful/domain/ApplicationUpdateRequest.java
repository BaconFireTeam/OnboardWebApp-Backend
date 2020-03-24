package com.baconfire.onboardwebapp.restful.domain;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ApplicationUpdateRequest {

    private int applicationId;
    private String status;
}
