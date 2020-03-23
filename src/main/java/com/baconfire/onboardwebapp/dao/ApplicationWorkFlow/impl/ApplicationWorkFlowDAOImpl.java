package com.baconfire.onboardwebapp.dao.ApplicationWorkFlow.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.ApplicationWorkFlow.ApplicationWorkFlowDAO;
import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository("applicationWorkFlowDaoImpl")
public class ApplicationWorkFlowDAOImpl extends AbstractHibernateDAO implements ApplicationWorkFlowDAO {

    @Override
    public ApplicationWorkFlow getById(int id) {
        String hql = "FROM ApplicationWorkFlow WHERE id = :id";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        try {
            ApplicationWorkFlow applicationWorkFlow = (ApplicationWorkFlow) query.getSingleResult();
            return applicationWorkFlow;
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public void updateApplication(ApplicationWorkFlow applicationWorkFlow) {
        Session session = getCurrentSession();
        session.merge(applicationWorkFlow);
    }

    @Override
    public ApplicationWorkFlow checkOpen(int employeeId) {
        String hql = "FROM ApplicationWorkFlow WHERE employeeID = :employeeId AND status = 'open' AND type = 'OPT'";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("employeeId", employeeId);
        try {
            ApplicationWorkFlow applicationWorkFlow = (ApplicationWorkFlow) query.getSingleResult();
            return applicationWorkFlow;
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public ApplicationWorkFlow checkPending(int employeeId) {
        String hql = "FROM ApplicationWorkFlow WHERE employeeID = :employeeId AND status = 'pending' AND type = 'OPT'";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("employeeId", employeeId);
        try {
            ApplicationWorkFlow applicationWorkFlow = (ApplicationWorkFlow) query.getSingleResult();
            return applicationWorkFlow;
        } catch(NoResultException e) {
            return null;
        }
    }
}
