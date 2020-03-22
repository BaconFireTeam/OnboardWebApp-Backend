package com.baconfire.onboardwebapp.dao.Contact.Impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.Contact.ContactDAO;
import com.baconfire.onboardwebapp.domain.Contact;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl extends AbstractHibernateDAO<Contact> implements ContactDAO {
    @Override
    public void saveContact(Contact contact) {
        getCurrentSession().save(contact);
    }
}
