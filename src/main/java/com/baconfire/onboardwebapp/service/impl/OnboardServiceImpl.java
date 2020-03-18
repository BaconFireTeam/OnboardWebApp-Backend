package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.User.UserDao;
import com.baconfire.onboardwebapp.domain.User;
import com.baconfire.onboardwebapp.service.OnboardService;
import org.springframework.stereotype.Service;

@Service
public class OnboardServiceImpl implements OnboardService {

    private UserDao userDaoImpl;

    @Override
    public User login(String username, String password) {
        return userDaoImpl.login(username, password);
    }
}
