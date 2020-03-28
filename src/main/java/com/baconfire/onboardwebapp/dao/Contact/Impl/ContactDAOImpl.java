package com.baconfire.onboardwebapp.dao.Contact.Impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.Contact.ContactDAO;
import com.baconfire.onboardwebapp.domain.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDAOImpl extends AbstractHibernateDAO<Contact> implements ContactDAO {
    public ContactDAOImpl() {
        setClazz(Contact.class);
    }

    @Override
    public int saveContact(Contact contact) {
        Contact c = (Contact) getCurrentSession().merge(contact);

        return c == null ? -1 : c.getId();
    }

    @Override
    public List<Contact> getContactByID(int employeeID) {
        return getCurrentSession().createQuery("FROM Contact WHERE employeeID =: id")
                .setParameter("id", employeeID)
                .getResultList();
    }
}
