package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.RegistrationToken.RegistrationTokenDAO;
import com.baconfire.onboardwebapp.service.TokenRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TokenRegisterServiceImpl implements TokenRegisterService {
    private RegistrationTokenDAO registrationTokenDAO;

    @Autowired
    public void setRegistrationTokenDAO(RegistrationTokenDAO registrationTokenDAO) {
        this.registrationTokenDAO = registrationTokenDAO;
    }

    @Override
    @Transactional
    public boolean checkToken(String token, String email) {
        return registrationTokenDAO.checkToken(token, email);
    }
}
