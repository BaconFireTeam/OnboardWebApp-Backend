package com.baconfire.onboardwebapp.dao.Contact.Impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.Contact.ContactDAO;
import com.baconfire.onboardwebapp.domain.Contact;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl extends AbstractHibernateDAO<Contact> implements ContactDAO {
    @Override
    public int saveContact(Contact contact) {
        Contact c = (Contact) getCurrentSession().merge(contact);

        return c == null ? -1 : c.getId();
    }
}
