package com.baconfire.onboardwebapp.restful.domain.Files;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DigitalDocumentResponse {
    private String type;
    private boolean required;
    private String templateLocation;
    private String Description;
}
