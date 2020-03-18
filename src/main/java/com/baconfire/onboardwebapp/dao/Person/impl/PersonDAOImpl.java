package com.baconfire.onboardwebapp.dao.Person.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.Permission.PermissionDAO;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl extends AbstractHibernateDAO implements PermissionDAO {
}
