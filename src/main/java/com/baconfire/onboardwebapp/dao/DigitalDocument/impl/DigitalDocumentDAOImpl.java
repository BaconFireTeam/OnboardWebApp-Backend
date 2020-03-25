package com.baconfire.onboardwebapp.dao.DigitalDocument.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.DigitalDocument.DigitalDocumentDAO;
import com.baconfire.onboardwebapp.domain.DigitalDocument;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DigitalDocumentDAOImpl extends AbstractHibernateDAO<DigitalDocument> implements DigitalDocumentDAO {
    public DigitalDocumentDAOImpl() {
        setClazz(DigitalDocument.class);
    }

    @Override
    public List<DigitalDocument> getFileByType(String type) {
        return getCurrentSession().createQuery("FROM DigitalDocument WHERE type =: type")
                    .setParameter("type", type)
                    .getResultList();
    }
}
