package com.baconfire.onboardwebapp.restful.domain.Files;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UploadFileResponse {
    private int employeeID;
    private String type;
    private String fileName;
    private String fileDownloadUri;
}
