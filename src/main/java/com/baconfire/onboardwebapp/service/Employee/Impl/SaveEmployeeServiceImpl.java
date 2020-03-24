package com.baconfire.onboardwebapp.service.Employee.Impl;

import com.baconfire.onboardwebapp.dao.Address.AddressDao;
import com.baconfire.onboardwebapp.dao.Contact.ContactDAO;
import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.domain.Address;
import com.baconfire.onboardwebapp.domain.Contact;
import com.baconfire.onboardwebapp.domain.Employee;
import com.baconfire.onboardwebapp.restful.domain.SubmitForm.AddressRequest;
import com.baconfire.onboardwebapp.restful.domain.SubmitForm.ContactRequest;
import com.baconfire.onboardwebapp.service.Employee.SaveEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaveEmployeeServiceImpl implements SaveEmployeeService {
    private EmployeeDAO employeeDAOImpl;
    private ContactDAO contactDAOImpl;
    private AddressDao addressDaoImpl;

    @Autowired
    public void setEmployeeDAOImpl(EmployeeDAO employeeDAOImpl) {
        this.employeeDAOImpl = employeeDAOImpl;
    }

    @Autowired
    public void setContactDAOImpl(ContactDAO contactDAOImpl) {
        this.contactDAOImpl = contactDAOImpl;
    }

    @Autowired
    public void setAddressDaoImpl(AddressDao addressDaoImpl) {
        this.addressDaoImpl = addressDaoImpl;
    }

    // call 3 dao
    // boolean validForm = this.employeeDaoImpl.saveEmployee(employee);
    @Override
    @Transactional
    public void saveEmployee(Employee employee, List<Address> addressList, List<ContactRequest> contactRequestList) {
        int id = this.saveEmployee(employee);
        this.saveAddressList(addressList, id);
        this.saveContactList(contactRequestList, id);
    }

    private void saveAddressList(List<Address> addressList, int id) {
        addressList.forEach(address -> {
            address.setPersonID(id);
            this.addressDaoImpl.saveAddress(address);
        });
    }

    private void saveContactList(List<ContactRequest> contactRequestList, int id) {
        for (ContactRequest contactRequest : contactRequestList) {
            Contact contact = new Contact();
            contact.setFirstname(contactRequest.getFirstname());
            contact.setMiddlename(contactRequest.getMiddlename());
            contact.setLastname(contactRequest.getLastname());
            contact.setEmail(contactRequest.getEmail());
            contact.setCellphone(contactRequest.getCellphone());
            contact.setAlternatephone(contactRequest.getAlternatephone());
            contact.setGender(contactRequest.getGender());

            AddressRequest contactAddressRequest = contactRequest.getAddress();
            Address contactAddress = new Address(contactAddressRequest.getAddressLine1(), contactAddressRequest.getAddressLine2()
                    , contactAddressRequest.getCity(), contactAddressRequest.getZipCode()
                    , contactAddressRequest.getStateName(), contactAddressRequest.getStateAbbr());

            contact.setIsEmergency("Y");
            contact.setRelationship(contactRequest.getRelationship());

            contact.setEmployeeID(id);
            int contactID = this.contactDAOImpl.saveContact(contact);
            contactAddress.setPersonID(contactID);
            this.addressDaoImpl.saveAddress(contactAddress);
        }
    }

    private int saveEmployee(Employee employee) {
        return this.employeeDAOImpl.saveEmployee(employee);
    }
}
