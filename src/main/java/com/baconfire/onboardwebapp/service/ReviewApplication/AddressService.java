package com.baconfire.onboardwebapp.service.ReviewApplication;

import com.baconfire.onboardwebapp.domain.Address;

public interface AddressService {
    Address getAdressByPersonID(int employeeID);
}
