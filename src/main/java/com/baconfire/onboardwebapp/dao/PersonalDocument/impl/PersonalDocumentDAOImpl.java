package com.baconfire.onboardwebapp.dao.PersonalDocument.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.PersonalDocument.PersonalDocumentDAO;
import com.baconfire.onboardwebapp.domain.PersonalDocument;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonalDocumentDAOImpl extends AbstractHibernateDAO<PersonalDocument> implements PersonalDocumentDAO {
    public PersonalDocumentDAOImpl() {
        setClazz(PersonalDocument.class);
    }

    @Override
    public void saveDocument(PersonalDocument personalDocument) {
        getCurrentSession().merge(personalDocument);
    }

    @Override
    public List<PersonalDocument> getFilesByIDAndType(int employeeID, String type) {
        return getCurrentSession().createQuery("FROM PersonalDocument WHERE employeeID =: id AND type =: type").setParameter("id", employeeID)
                .setParameter("type", type)
                .getResultList();
    }
}
