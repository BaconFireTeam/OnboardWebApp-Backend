package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.service.TokenRegisterService;
import org.springframework.stereotype.Service;

@Service
public class TokenRegisterServiceImpl implements TokenRegisterService {
    @Override
    public boolean checkToken(String token, String email) {
        return false;
    }
}
