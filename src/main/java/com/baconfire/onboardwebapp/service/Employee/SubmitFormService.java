package com.baconfire.onboardwebapp.service.Employee;

import com.baconfire.onboardwebapp.restful.domain.SubmitForm.PersonRequest;

public interface SubmitFormService {
    boolean submitForm(PersonRequest personRequest);
}
