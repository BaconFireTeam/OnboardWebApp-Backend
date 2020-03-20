package com.baconfire.onboardwebapp.restful.domain;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ContactRequest {
    private int personId;
    private String relationship;
    private String title;
    private String isReference;
    private String isEmergency;
    private String isLandlord;
}
