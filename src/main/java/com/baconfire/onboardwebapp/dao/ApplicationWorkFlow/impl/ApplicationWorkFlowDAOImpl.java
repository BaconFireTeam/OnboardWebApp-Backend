package com.baconfire.onboardwebapp.dao.ApplicationWorkFlow.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.ApplicationWorkFlow.ApplicationWorkFlowDAO;
import com.baconfire.onboardwebapp.domain.ApplicationWorkFlow;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository("applicationWorkFlowDaoImpl")
public class ApplicationWorkFlowDAOImpl extends AbstractHibernateDAO<ApplicationWorkFlow> implements ApplicationWorkFlowDAO {

    public ApplicationWorkFlowDAOImpl() {
        setClazz(ApplicationWorkFlow.class);
    }

    @Override
    public ApplicationWorkFlow getById(int id) {
        return findById(id);
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

    @Override
    public List<ApplicationWorkFlow> getApplicationByStatus(String status) {
        return getCurrentSession().createQuery("FROM ApplicationWorkFlow WHERE status LIKE: status")
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<ApplicationWorkFlow> getOnboardingApplication() {
        return getCurrentSession().createQuery("FROM ApplicationWorkFlow WHERE type = 'Onboarding'")
                .getResultList();
    }

    @Override
    public void updateComment(int employeeID, String comment) {
        Session session = getCurrentSession();
        ApplicationWorkFlow applicationWorkFlow = (ApplicationWorkFlow) session
                .createQuery("FROM ApplicationWorkFlow WHERE employeeID =: id AND type = 'Onboarding'")
                .setParameter("id", employeeID)
                .getSingleResult();
        applicationWorkFlow.setComments(comment);

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String curDate = formatter.format(date);

        applicationWorkFlow.setModificationDate(curDate);

        session.update(applicationWorkFlow);
    }
}
