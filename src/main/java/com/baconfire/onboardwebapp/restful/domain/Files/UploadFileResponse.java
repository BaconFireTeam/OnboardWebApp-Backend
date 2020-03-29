package com.baconfire.onboardwebapp.restful.domain.Files;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UploadFileResponse {
    private int fileID;
    private int employeeID;
    private String type;
    private String fileName;
    private String fileDownloadUri;

    public UploadFileResponse(int id, String type, String fileName, String fileDownloadUri) {
        this.employeeID = id;
        this.type = type;
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
    }
}
