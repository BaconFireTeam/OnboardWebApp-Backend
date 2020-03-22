package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.Address.AddressDao;
import com.baconfire.onboardwebapp.dao.Contact.ContactDAO;
import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.dao.VisaStatus.VisaStatusDAO;
import com.baconfire.onboardwebapp.domain.*;
import com.baconfire.onboardwebapp.restful.domain.SubmitForm.*;
import com.baconfire.onboardwebapp.service.SubmitFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubmitFormServiceImpl implements SubmitFormService {
    private EmployeeDAO employeeDaoImpl;
    private ContactDAO contactDaoImpl;
    private VisaStatusDAO visaStatusDAOImpl;
    private AddressDao addressDaoImpl;

    @Autowired
    public void setEmployeeDaoImpl(EmployeeDAO employeeDaoImpl) {
        this.employeeDaoImpl = employeeDaoImpl;
    }

    @Autowired
    public void setContactDaoImpl(ContactDAO contactDaoImpl) {
        this.contactDaoImpl = contactDaoImpl;
    }

    @Autowired
    public void setVisaStatusDAOImpl(VisaStatusDAO visaStatusDAOImpl) {
        this.visaStatusDAOImpl = visaStatusDAOImpl;
    }

    @Autowired
    public void setAddressDaoImpl(AddressDao addressDaoImpl) {
        this.addressDaoImpl = addressDaoImpl;
    }

    @Override
    @Transactional
    public boolean submitForm(PersonRequest employeeInfo) {
//        System.out.println(employeeInfo.toString());

        Employee employee = new Employee();

        // employee's person info
        employee.setFirstname(employeeInfo.getFirstname());
        employee.setMiddlename(employeeInfo.getMiddlename());
        employee.setLastname(employeeInfo.getLastname());
        employee.setEmail(employeeInfo.getEmail());
        employee.setCellphone(employeeInfo.getCellphone());
        employee.setAlternatephone(employeeInfo.getAlternatephone());
        employee.setGender(employeeInfo.getGender());
        employee.setSSN(employeeInfo.getSsn());
        employee.setDOB(employeeInfo.getDob());
        employee.setTitle("employee");
        employee.setManagerID("not assign yet");
        employee.setStartDate("not assign yet");
        employee.setEndDate("not assign yet");

        // employee car information
        DriverLicenseRequest driverLicenseRequest = employeeInfo.getDriverLicense();
        employee.setCar(driverLicenseRequest.getCar());
        employee.setDriverLisence(driverLicenseRequest.getLicenseNum());
        employee.setDriverLisence_ExpirationDate(driverLicenseRequest.getExpirationDate());

        // employee visa information
        VisaRequest visaRequest = employeeInfo.getVisa();

        int visaID = this.visaStatusDAOImpl.getIDByType(visaRequest.getType());

        if (visaID == -1) {
            return false;
        }

        employee.setVisaStatusID(visaID);
        employee.setVisaStartDate(visaRequest.getStartDate());
        employee.setVisaEndDate(visaRequest.getEndDate());

        // employee address info
        List<AddressRequest> addressRequestList = employeeInfo.getAddressList();
        List<Address> addressList = new ArrayList<>();

        for (AddressRequest addressRequest : addressRequestList) {
            Address address = new Address(addressRequest.getAddressLine1(), addressRequest.getAddressLine2()
                    , addressRequest.getCity(), addressRequest.getZipCode()
                    , addressRequest.getStateName(), addressRequest.getStateAbbr());

            addressList.add(address);
        }

        employee.setAddressList(addressList);

        // employee emergency contact
        List<ContactRequest> contactRequestList = employeeInfo.getEmergencyContactList();
        List<Contact> contactList = new ArrayList<>();
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
            List<Address> contactAddressList = new ArrayList<>();
            Address contactAddress = new Address(contactAddressRequest.getAddressLine1(), contactAddressRequest.getAddressLine2()
                    , contactAddressRequest.getCity(), contactAddressRequest.getZipCode()
                    , contactAddressRequest.getStateName(), contactAddressRequest.getStateAbbr());

            contactAddressList.add(contactAddress);

            contact.setAddressList(contactAddressList);

            contact.setIsEmergency("Y");
            contact.setRelationship(contactRequest.getRelationship());

//            this.contactDaoImpl.saveContact(contact);

            contact.setEmployee(employee);
            contactList.add(contact);
        }

        employee.setContactList(contactList);

        boolean validForm = this.employeeDaoImpl.saveEmployee(employee);
        return true;
    }
}
