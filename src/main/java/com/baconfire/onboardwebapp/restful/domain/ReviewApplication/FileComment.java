package com.baconfire.onboardwebapp.restful.domain.ReviewApplication;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class FileComment {
    List<CommentRequest> commentRequestList;
}
