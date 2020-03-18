package com.baconfire.onboardwebapp.dao.User;

import com.baconfire.onboardwebapp.domain.User;

public interface UserDao {
    User login(String username, String password);
}
