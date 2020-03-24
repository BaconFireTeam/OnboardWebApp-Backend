package com.baconfire.onboardwebapp.service.FileStorage;

import com.baconfire.onboardwebapp.domain.PersonalDocument;

import java.util.List;

public interface PersonalDocumentService {
    void storeFile(int employeeID, String type, String fileDownloadUri, String fileName);

    List<PersonalDocument> getFilesByIDAndType(int employeeID, String type);
}
