package com.baconfire.onboardwebapp.service.ReviewApplication.Impl;

import com.baconfire.onboardwebapp.dao.Address.AddressDao;
import com.baconfire.onboardwebapp.domain.Address;
import com.baconfire.onboardwebapp.service.ReviewApplication.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressDao addressDaoImpl;

    @Autowired
    public void setAddressDaoImpl(AddressDao addressDaoImpl) {
        this.addressDaoImpl = addressDaoImpl;
    }

    @Override
    @Transactional
    public Address getAdressByPersonID(int employeeID) {
        return this.addressDaoImpl.getAdressByPersonID(employeeID);
    }
}
