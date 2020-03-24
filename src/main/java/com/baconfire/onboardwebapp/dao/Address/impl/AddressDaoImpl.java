package com.baconfire.onboardwebapp.dao.Address.impl;

import com.baconfire.onboardwebapp.dao.AbstractHibernateDAO;
import com.baconfire.onboardwebapp.dao.Address.AddressDao;
import com.baconfire.onboardwebapp.domain.Address;
import com.baconfire.onboardwebapp.domain.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends AbstractHibernateDAO<Address> implements AddressDao {

    @Override
    public void saveAddress(Address address) {
        getCurrentSession().save(address);
    }

    @Override
    public void saveEmployee(Employee employee) {

    }
}
