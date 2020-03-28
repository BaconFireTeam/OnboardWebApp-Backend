package com.baconfire.onboardwebapp.service.ReviewApplication;

import com.baconfire.onboardwebapp.domain.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getContactByID(int employeeID);
}
