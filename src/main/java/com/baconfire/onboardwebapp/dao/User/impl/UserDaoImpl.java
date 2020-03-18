package com.baconfire.onboardwebapp.dao.User.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.User.UserDao;
import com.baconfire.onboardwebapp.domain.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository("userDaoImpl")
public class UserDaoImpl extends AbstractHibernateDAO<User> implements UserDao {
    public UserDaoImpl() {
        setClazz(User.class);
    }
    @Override
    public User login(String username, String password) {
        String hql = "FROM User WHERE UserName = :username AND Password = :password";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }
}
