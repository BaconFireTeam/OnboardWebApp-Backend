package com.baconfire.onboardwebapp.service.FileStorage;

import com.baconfire.onboardwebapp.domain.PersonalDocument;

import java.util.List;
import java.util.Map;

public interface PersonalDocumentService {
    void storeFile(int employeeID, String type, String fileDownloadUri, String fileName);

    List<PersonalDocument> getFilesByIDAndType(int employeeID, String type);

    void updateComment(int fileID, String comment);

    List<PersonalDocument> getComment(int employeeID);
}
