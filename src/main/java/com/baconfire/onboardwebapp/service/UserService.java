package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.restful.domain.UserRequest;

public interface UserService {
    boolean checkUniqueUsername(String username);

    boolean registerUser(UserRequest userRequest);
}
