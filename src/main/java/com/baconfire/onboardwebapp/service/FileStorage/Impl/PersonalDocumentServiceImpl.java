package com.baconfire.onboardwebapp.service.FileStorage.Impl;

import com.baconfire.onboardwebapp.dao.Employee.EmployeeDAO;
import com.baconfire.onboardwebapp.dao.PersonalDocument.PersonalDocumentDAO;
import com.baconfire.onboardwebapp.domain.Employee;
import com.baconfire.onboardwebapp.domain.PersonalDocument;
import com.baconfire.onboardwebapp.service.FileStorage.PersonalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalDocumentServiceImpl implements PersonalDocumentService {
    private PersonalDocumentDAO personalDocumentDAOImpl;
    private EmployeeDAO employeeDAOImpl;

    @Autowired
    public void setPersonalDocumentDAOImpl(PersonalDocumentDAO personalDocumentDAOImpl) {
        this.personalDocumentDAOImpl = personalDocumentDAOImpl;
    }

    @Autowired
    public void setEmployeeDAOImpl(EmployeeDAO employeeDAOImpl) {
        this.employeeDAOImpl = employeeDAOImpl;
    }

    @Override
    @Transactional
    public void storeFile(int employeeID, String type, String fileDownloadUri, String fileName) {
        Employee employee = this.employeeDAOImpl.getEmployeeByID(employeeID);
        PersonalDocument personalDocument = new PersonalDocument();
        personalDocument.setEmployeeID(employeeID);
        personalDocument.setType(type);
        personalDocument.setPath(fileDownloadUri);
        personalDocument.setTitle(fileName);

        // mm-dd-yyyy-hh-mm-ss -> mm/dd/yyyy/hh/mm/ss
        String createDate = fileName.split("_")[1].replace("-", "/");

        personalDocument.setCreateDate(createDate);
        personalDocument.setCreateBy(employee.getFirstname() + " " + employee.getLastname());

//        System.out.println(personalDocument.toString());
        this.personalDocumentDAOImpl.saveDocument(personalDocument);
    }

    @Override
    @Transactional
    public List<PersonalDocument> getFilesByIDAndType(int employeeID, String type) {
        return personalDocumentDAOImpl.getFilesByIDAndType(employeeID, type);
    }

    @Override
    @Transactional
    public void updateComment(int fileID, String comment) {
        this.personalDocumentDAOImpl.updateComment(fileID, comment);
    }
}
