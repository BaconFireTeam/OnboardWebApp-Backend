package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.User.UserDao;
import com.baconfire.onboardwebapp.domain.User;
import com.baconfire.onboardwebapp.service.OnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OnboardServiceImpl implements OnboardService {

    private UserDao userDaoImpl;

    @Autowired
    public void setUserDaoImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    @Transactional
    public User login(String username, String password) {
        return userDaoImpl.login(username, password);
    }

    @Override
    public void register(User user) {
//        user.setPersonID(null);
//        need to figure out the personId
    }
}
