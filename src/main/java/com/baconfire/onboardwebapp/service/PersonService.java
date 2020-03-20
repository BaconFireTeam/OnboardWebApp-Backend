package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.restful.domain.PersonRequest;

public interface PersonService {
    void savePersonInfo(PersonRequest personRequest);
}
