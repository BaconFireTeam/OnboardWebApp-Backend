package com.baconfire.onboardwebapp.service.FileStorage.Impl;

import com.baconfire.onboardwebapp.dao.DigitalDocument.DigitalDocumentDAO;
import com.baconfire.onboardwebapp.domain.DigitalDocument;
import com.baconfire.onboardwebapp.service.FileStorage.DigitalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DigitalDocumentServiceImpl implements DigitalDocumentService {
    private DigitalDocumentDAO digitalDocumentDAOImpl;

    @Autowired
    public void setDigitalDocumentDAOImpl(DigitalDocumentDAO digitalDocumentDAOImpl) {
        this.digitalDocumentDAOImpl = digitalDocumentDAOImpl;
    }

    @Override
    @Transactional
    public List<DigitalDocument> getFileByType(String type) {
        return this.digitalDocumentDAOImpl.getFileByType(type);
    }
}
