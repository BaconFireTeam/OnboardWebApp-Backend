package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.domain.User;

public interface OnboardService {

    public User login(String username, String password);

    public void register(User user);
}
