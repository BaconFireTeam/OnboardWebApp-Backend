package com.baconfire.onboardwebapp.service.ReviewApplication.Impl;

import com.baconfire.onboardwebapp.dao.Contact.ContactDAO;
import com.baconfire.onboardwebapp.domain.Contact;
import com.baconfire.onboardwebapp.service.ReviewApplication.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private ContactDAO contactDAOImpl;

    @Autowired
    public void setContactDAOImpl(ContactDAO contactDAOImpl) {
        this.contactDAOImpl = contactDAOImpl;
    }

    @Override
    @Transactional
    public List<Contact> getContactByID(int employeeID) {
        return this.contactDAOImpl.getContactByID(employeeID);
    }
}
