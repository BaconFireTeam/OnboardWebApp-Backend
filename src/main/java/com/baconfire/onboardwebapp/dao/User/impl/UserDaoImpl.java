package com.baconfire.onboardwebapp.dao.User.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.User.UserDao;
import com.baconfire.onboardwebapp.domain.Role;
import com.baconfire.onboardwebapp.domain.User;
import com.baconfire.onboardwebapp.domain.UserRole;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository("userDaoImpl")
public class UserDaoImpl extends AbstractHibernateDAO implements UserDao {
    public UserDaoImpl() {
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

    @Override
    public UserRole getUserRole(int id) {
        String hql = "FROM UserRole WHERE UserID = :id";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        try {
            UserRole ur = (UserRole) query.getSingleResult();
            return ur;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Role getRole(int id) {
        String hql = "FROM Role WHERE Id = :id";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        try {
            Role role = (Role) query.getSingleResult();
            return role;
        } catch (NoResultException e) {
            return null;
        }
    }
}
