package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.restful.domain.PersonRequest;

public interface SubmitFormService {
    void submitForm(PersonRequest personRequest);
}
