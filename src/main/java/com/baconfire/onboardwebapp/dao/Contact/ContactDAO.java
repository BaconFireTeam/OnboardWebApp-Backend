package com.baconfire.onboardwebapp.dao.Contact;

import com.baconfire.onboardwebapp.domain.Contact;

import java.util.List;

public interface ContactDAO {
    int saveContact(Contact contact);

    List<Contact> getContactByID(int employeeID);
}
