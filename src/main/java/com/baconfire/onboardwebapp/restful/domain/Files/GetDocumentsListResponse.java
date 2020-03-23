package com.baconfire.onboardwebapp.restful.domain.Files;

import com.baconfire.onboardwebapp.domain.DigitalDocument;
import com.baconfire.onboardwebapp.domain.PersonalDocument;
import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import lombok.*;

import java.util.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class GetDocumentsListResponse {
    private ServiceStatus serviceStatus;
    private List<UploadFileResponse> uploadFileResponseList;
    private List<DigitalDocumentResponse> digitalDocumentResponseList;
}
