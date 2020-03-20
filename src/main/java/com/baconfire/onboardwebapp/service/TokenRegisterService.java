package com.baconfire.onboardwebapp.service;

public interface TokenRegisterService {
    boolean checkToken(String token, String email);
}
