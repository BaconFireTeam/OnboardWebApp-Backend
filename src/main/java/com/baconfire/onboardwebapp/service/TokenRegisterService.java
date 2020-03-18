package com.baconfire.onboardwebapp.service;

public interface TokenRegisterService {
    public boolean checkToken(String token, String email);
}
