package com.baconfire.onboardwebapp.service.Employee;

import com.baconfire.onboardwebapp.restful.domain.SubmitForm.PersonRequest;

public interface SubmitFormService {
    int submitForm(PersonRequest personRequest);
}
