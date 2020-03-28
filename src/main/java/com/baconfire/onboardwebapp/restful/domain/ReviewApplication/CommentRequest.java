package com.baconfire.onboardwebapp.restful.domain.ReviewApplication;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CommentRequest {
    private String employeeID;
    private int fileID;
    private String comment;
}
