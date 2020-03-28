package com.baconfire.onboardwebapp.dao.VisaStatus.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.VisaStatus.VisaStatusDAO;
import com.baconfire.onboardwebapp.domain.VisaStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisaStatusDAOImpl extends AbstractHibernateDAO<VisaStatus> implements VisaStatusDAO {
    public VisaStatusDAOImpl() {
        setClazz(VisaStatus.class);
    }

    @Override
    public int getIDByType(String type) {
        List<VisaStatus> visa = getCurrentSession().createQuery("FROM VisaStatus WHERE visaType =: type")
                .setParameter("type", type)
                .getResultList();
        return visa.size() == 0 ? -1 : visa.get(0).getId();
    }

    @Override
    public String getVisaStatusByID(int visaStatusId) {
        return findById(visaStatusId).getVisaType();
    }
}
