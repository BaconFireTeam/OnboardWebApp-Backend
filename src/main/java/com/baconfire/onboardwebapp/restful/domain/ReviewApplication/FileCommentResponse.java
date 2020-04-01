package com.baconfire.onboardwebapp.restful.domain.ReviewApplication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileCommentResponse {
    List<CommentResponse> fileCommentList;
}
