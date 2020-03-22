package com.baconfire.onboardwebapp.service;

import com.baconfire.onboardwebapp.restful.domain.SubmitForm.PersonRequest;

public interface SubmitFormService {
    boolean submitForm(PersonRequest personRequest);
}
