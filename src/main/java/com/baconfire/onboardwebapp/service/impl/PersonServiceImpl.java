package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.Person.PersonDAO;
import com.baconfire.onboardwebapp.domain.Person;
import com.baconfire.onboardwebapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonDAO personDAOImpl;

    @Autowired
    public void setPersonDAOImpl(PersonDAO personDAOImpl) {
        this.personDAOImpl = personDAOImpl;
    }

    @Override
    @Transactional
    public Person getPersonByID(int employeeID) {
        return this.personDAOImpl.getPersonByID(employeeID);
    }
}
