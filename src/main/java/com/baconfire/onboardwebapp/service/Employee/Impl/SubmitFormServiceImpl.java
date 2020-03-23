package com.baconfire.onboardwebapp.service.Employee.Impl;

import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.dao.VisaStatus.VisaStatusDAO;
import com.baconfire.onboardwebapp.domain.*;
import com.baconfire.onboardwebapp.restful.domain.SubmitForm.*;
import com.baconfire.onboardwebapp.service.Employee.SaveEmployeeService;
import com.baconfire.onboardwebapp.service.Employee.SubmitFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubmitFormServiceImpl implements SubmitFormService {
    private EmployeeDAO employeeDaoImpl;
    private VisaStatusDAO visaStatusDAOImpl;

    private SaveEmployeeService saveEmployeeServiceImpl;

    @Autowired
    public void setEmployeeDaoImpl(EmployeeDAO employeeDaoImpl) {
        this.employeeDaoImpl = employeeDaoImpl;
    }

    @Autowired
    public void setVisaStatusDAOImpl(VisaStatusDAO visaStatusDAOImpl) {
        this.visaStatusDAOImpl = visaStatusDAOImpl;
    }

    @Autowired
    public void setSaveEmployeeServiceImpl(SaveEmployeeService saveEmployeeServiceImpl) {
        this.saveEmployeeServiceImpl = saveEmployeeServiceImpl;
    }

    @Override
    @Transactional
    public boolean submitForm(PersonRequest employeeInfo) {
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

        employee.setVisaStatusId(visaID);
        employee.setVisaStartDate(visaRequest.getStartDate());
        employee.setVisaEndDate(visaRequest.getEndDate());

        // employee address info
        List<AddressRequest> addressRequestList = employeeInfo.getAddressList();
        List<Address> addressList = new ArrayList<>();

        for (AddressRequest addressRequest : addressRequestList) {
            Address address = new Address(addressRequest.getAddressLine1(), addressRequest.getAddressLine2()
                    , addressRequest.getCity(), addressRequest.getZipCode()
                    , addressRequest.getStateName(), addressRequest.getStateAbbr());

//            address.setPerson(employee);
            addressList.add(address);
        }

//        employee.setAddressList(addressList);

        // employee emergency contact
        List<ContactRequest> contactRequestList = employeeInfo.getEmergencyContactList();



//        employee.setContactList(contactList);

        this.saveEmployeeServiceImpl.saveEmployee(employee, addressList, contactRequestList);
        // boolean validForm = this.employeeDaoImpl.saveEmployee(employee);
        // get personID or EmployeeID
        // save addressList , contactList
        return true;
    }
}
