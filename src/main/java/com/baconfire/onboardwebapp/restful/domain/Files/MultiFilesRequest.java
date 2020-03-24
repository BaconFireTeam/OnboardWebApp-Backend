package com.baconfire.onboardwebapp.restful.domain.Files;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class MultiFilesRequest {
    private MultipartFile[] files;
    private int employeeID;
    private String type;
}
