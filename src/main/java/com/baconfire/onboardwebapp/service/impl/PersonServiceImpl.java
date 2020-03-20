package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.Person.PersonDAO;
import com.baconfire.onboardwebapp.domain.Person;
import com.baconfire.onboardwebapp.restful.domain.PersonRequest;
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
    public void savePersonInfo(PersonRequest personRequest) {
//        System.out.println(personRequest.toString());
        int id = personRequest.getId();
        String fn = personRequest.getFirstname();
        String ln = personRequest.getLastname();
        String mn = personRequest.getMiddlename();
        String email = personRequest.getEmail();
        String cellphone = personRequest.getCellphone();
        String acphone = personRequest.getAlternatephone();
        String gender = personRequest.getGender();
        String ssn = personRequest.getSsn();
        String dob = personRequest.getDob();

        Person person = new Person(id, fn, ln, mn, email, cellphone, acphone, gender, ssn, dob);
        this.personDAOImpl.savePerson(person);
    }
}
