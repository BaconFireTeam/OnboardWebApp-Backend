package com.baconfire.onboardwebapp.service.FileStorage;

import com.baconfire.onboardwebapp.domain.DigitalDocument;

import java.util.List;

public interface DigitalDocumentService {
    List<DigitalDocument> getFileByType(String type);
}
