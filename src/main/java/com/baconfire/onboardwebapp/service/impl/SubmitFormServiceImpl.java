
package com.baconfire.onboardwebapp.service.impl;

import com.baconfire.onboardwebapp.dao.Contact.ContactDAO;
import com.baconfire.onboardwebapp.dao.Contact.impl.ContactDAOImpl;
import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.dao.Employee.impl.EmployeeDAOImpl;
import com.baconfire.onboardwebapp.dao.Person.PersonDAO;
import com.baconfire.onboardwebapp.domain.Employee;
import com.baconfire.onboardwebapp.domain.Person;
import com.baconfire.onboardwebapp.restful.domain.*;
import com.baconfire.onboardwebapp.service.SubmitFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubmitFormServiceImpl implements SubmitFormService {
    private PersonDAO personDaoImpl;
    private EmployeeDAO employeeDaoImpl;
    private ContactDAO contactDaoImpl;

    @Autowired
    public void setPersonDaoImpl(PersonDAO personDaoImpl) {
        this.personDaoImpl = personDaoImpl;
    }

    @Autowired
    public void setEmployeeDao(EmployeeDAO employeeDaoImpl) {
        this.employeeDaoImpl = employeeDaoImpl;
    }

    @Autowired
    public void setContactDaoImpl(ContactDAO contactDaoImpl) {
        this.contactDaoImpl = contactDaoImpl;
    }

    @Override
    @Transactional
    public void submitForm(PersonRequest employeeInfo) {
//        System.out.println(employeeInfo.toString());
        int id = employeeInfo.getId();
        String fn = employeeInfo.getFirstname();
        String ln = employeeInfo.getLastname();
        String mn = employeeInfo.getMiddlename();
        String email = employeeInfo.getEmail();
        String cellphone = employeeInfo.getCellphone();
        String acphone = employeeInfo.getAlternatephone();
        String gender = employeeInfo.getGender();
        String ssn = employeeInfo.getSsn();
        String dob = employeeInfo.getDob();

        Employee employee = new Employee();
        employee.setFirstname(fn);
        employee.setMiddlename(mn);
        employee.setLastname(ln);
        employee.setEmail(email);
        employee.setCellphone(cellphone);
        employee.setAlternatephone(acphone);
        employee.setGender(gender);
        employee.setSSN(ssn);
        employee.setDOB(dob);
        employee.setTitle("employee");
        employee.setManagerID("1");
        employee.setStartDate("test");
        employee.setEndDate("test");

        DriverLicenseRequest driverLicenseRequest = employeeInfo.getDriverLicense();
        employee.setCar(driverLicenseRequest.getCar());
        employee.setDriverLisence(driverLicenseRequest.getLicenseNum());
        employee.setDriverLisence_ExpirationDate(driverLicenseRequest.getExpirationDate());

        VisaRequest visaRequest = employeeInfo.getVisa();

        String visaType = visaRequest.getType();


        List<AddressRequest> addressRequestList = employeeInfo.getAddressList();
        List<ContactRequest> contactRequestList = employeeInfo.getContactList();

        Person person = new Person(id, fn, ln, mn, email, cellphone, acphone, gender, ssn, dob);
        this.personDaoImpl.savePerson(person);
    }
}

