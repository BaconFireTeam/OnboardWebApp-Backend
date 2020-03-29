package com.baconfire.onboardwebapp.restful.domain.ReviewApplication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class CommentResponse {
    private int fileID;
    private String fileDownloadUri;
    private String fileName;
    private String comment;
}
