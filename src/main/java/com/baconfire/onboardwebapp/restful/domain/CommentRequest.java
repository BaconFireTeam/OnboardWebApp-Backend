package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.restful.domain.SubmitForm.AddressRequest;
import com.baconfire.onboardwebapp.restful.domain.SubmitForm.PersonRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CommentRequest {
    private Integer reportID;
    private Integer employeeID;
    private String comment;
    private String createdDate;

}