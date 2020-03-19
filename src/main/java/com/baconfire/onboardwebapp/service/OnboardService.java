package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.domain.Role;
import com.baconfire.onboardwebapp.domain.User;

public interface OnboardService {

    public User login(String username, String password);

    public Role getRole(User user);

    public void register(User user);
}
