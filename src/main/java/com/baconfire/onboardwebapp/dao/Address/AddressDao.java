package com.baconfire.onboardwebapp.dao.Address;

import com.baconfire.onboardwebapp.domain.Address;
import com.baconfire.onboardwebapp.domain.Employee;

public interface AddressDao {
    void saveAddress(Address address);

    void saveEmployee(Employee employee);
}
