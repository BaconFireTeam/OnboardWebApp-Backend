package com.baconfire.onboardwebapp.dao.PersonalDocument;

import com.baconfire.onboardwebapp.domain.PersonalDocument;

import java.util.List;

public interface PersonalDocumentDAO {
    void saveDocument(PersonalDocument personalDocument);

    List<PersonalDocument> getFilesByIDAndType(int employeeID, String type);

    void updateComment(int employeeID, String comment);
}
