package com.baconfire.onboardwebapp.dao.PersonalDocument.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.PersonalDocument.PersonalDocumentDAO;
import com.baconfire.onboardwebapp.domain.PersonalDocument;
import org.springframework.stereotype.Repository;

@Repository
public class PersonalDocumentDAOImpl extends AbstractHibernateDAO<PersonalDocument> implements PersonalDocumentDAO {

    @Override
    public void storeFile(String fileDownloadUri) {

    }
}
