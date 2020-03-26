package com.baconfire.onboardwebapp.service.Employee;

import com.baconfire.onboardwebapp.domain.Address;
import com.baconfire.onboardwebapp.domain.Contact;
import com.baconfire.onboardwebapp.domain.Employee;
import com.baconfire.onboardwebapp.restful.domain.SubmitForm.ContactRequest;

import java.util.List;

public interface SaveEmployeeService {
    int saveEmployee(Employee employee, List<Address> addressList, List<ContactRequest> contactRequestList);
}
