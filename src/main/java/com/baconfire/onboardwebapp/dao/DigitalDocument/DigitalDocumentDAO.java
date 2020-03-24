package com.baconfire.onboardwebapp.dao.DigitalDocument;

import com.baconfire.onboardwebapp.domain.DigitalDocument;

import java.util.List;

public interface DigitalDocumentDAO {
    List<DigitalDocument> getFileByType(String type);
}
