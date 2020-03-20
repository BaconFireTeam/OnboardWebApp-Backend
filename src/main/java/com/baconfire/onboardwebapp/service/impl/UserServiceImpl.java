package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.User.UserDao;
import com.baconfire.onboardwebapp.dao.Person.PersonDAO;
import com.baconfire.onboardwebapp.domain.Person;
import com.baconfire.onboardwebapp.domain.User;
import com.baconfire.onboardwebapp.restful.domain.UserRequest;
import com.baconfire.onboardwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDaoImpl;
    private PersonDAO personDaoImpl;


    @Autowired
    public void setUserDaoImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Autowired
    public void setPersonDaoImpl(PersonDAO personDaoImpl) {
        this.personDaoImpl = personDaoImpl;
    }

    @Override
    @Transactional
    public boolean checkUniqueUsername(String username) {
        return this.userDaoImpl.checkUsername(username);
    }

    @Override
    @Transactional
    public boolean registerUser(UserRequest userRequest) {
        String username = userRequest.getUsername();
        String email = userRequest.getEmail();
        String password = userRequest.getPassword();

        if (!this.checkUniqueUsername(username)) {
            return false;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();

        Person p = new Person("-","-","-","-","-","-","-","-","-");
        this.personDaoImpl.savePerson(p);
//        User user = new User(username, email, password, formatter.format(date), formatter.format(date));
        User user = new User(username, email, password, p, formatter.format(date), formatter.format(date));
        this.userDaoImpl.registerUser(user);

        return true;
    }
}
