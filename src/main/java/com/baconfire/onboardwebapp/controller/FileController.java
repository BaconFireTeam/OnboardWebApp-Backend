package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.domain.DigitalDocument;
import com.baconfire.onboardwebapp.domain.PersonalDocument;
import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import com.baconfire.onboardwebapp.restful.domain.Files.*;
import com.baconfire.onboardwebapp.service.ApplicationService;
import com.baconfire.onboardwebapp.service.FileStorage.DigitalDocumentService;
import com.baconfire.onboardwebapp.service.FileStorage.FileStorageService;
import com.baconfire.onboardwebapp.service.FileStorage.PersonalDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private FileStorageService fileStorageServiceImpl;
    private PersonalDocumentService personalDocumentServiceImpl;
    private DigitalDocumentService digitalDocumentServiceImpl;
    private ApplicationService applicationServiceImpl;

    @Autowired
    public void setFileStorageServiceImpl(FileStorageService fileStorageServiceImpl) {
        this.fileStorageServiceImpl = fileStorageServiceImpl;
    }

    @Autowired
    public void setPersonalDocumentServiceImpl(PersonalDocumentService personalDocumentServiceImpl) {
        this.personalDocumentServiceImpl = personalDocumentServiceImpl;
    }

    @Autowired
    public void setDigitalDocumentServiceImpl(DigitalDocumentService digitalDocumentServiceImpl) {
        this.digitalDocumentServiceImpl = digitalDocumentServiceImpl;
    }

    @Autowired
    public void setApplicationServiceImpl(ApplicationService applicationServiceImpl) {
        this.applicationServiceImpl = applicationServiceImpl;
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
                                         @RequestParam("employeeID") String employeeID,
                                         @RequestParam("type") String type) {
        String fileName = fileStorageServiceImpl.storeFile(file, Integer.valueOf(employeeID), type);

        String folderType = "Onboarding".equals(type) ? "OnboardingDocuments/" : "OPTDocuments/";

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("Documents/PersonalDocuments/" + folderType)
                .path(fileName)
                .toUriString();

        this.personalDocumentServiceImpl.storeFile(Integer.valueOf(employeeID), type, fileDownloadUri, fileName);

        return new UploadFileResponse(Integer.valueOf(employeeID), type, fileName, fileDownloadUri);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
                                                        @RequestParam("employeeID") String employeeID,
                                                        @RequestParam("type") String type) {
        List<UploadFileResponse> res = Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file, employeeID, type))
                .collect(Collectors.toList());

        if (res.size() != 0) {
            this.applicationServiceImpl.updateOnboardingApplication(Integer.valueOf(employeeID), "Pending");
        }
        return res;
    }

    @GetMapping("/getPersonalDocument")
    public GetDocumentsListResponse getFiles(int employeeID, String type) {
        GetDocumentsListResponse response = new GetDocumentsListResponse();
        List<PersonalDocument> personalDocumentList = this.personalDocumentServiceImpl.getFilesByIDAndType(employeeID, type);

        if (personalDocumentList.size() == 0) {
            response.setServiceStatus(new ServiceStatus("401", false, "Can't find employee"));
        } else {
            response.setServiceStatus(new ServiceStatus("200", true, ""));
        }

        List<UploadFileResponse> uploadFileResponseList = new ArrayList<>();
        personalDocumentList.forEach(personalDocument -> {
            uploadFileResponseList.add(new UploadFileResponse(personalDocument.getId(), Integer.valueOf(employeeID), personalDocument.getType()
                                    , personalDocument.getTitle()
                                    , personalDocument.getPath()));
        });

        response.setUploadFileResponseList(uploadFileResponseList);
        return response;
    }

    @GetMapping("/getDigitalDocument")
    public GetDocumentsListResponse getDigitalDocuments(@RequestParam("type") String type) {
        GetDocumentsListResponse response = new GetDocumentsListResponse();

        List<DigitalDocument> digitalDocumentList = this.digitalDocumentServiceImpl.getFileByType(type);

        if (digitalDocumentList.size() == 0) {
            response.setServiceStatus(new ServiceStatus("401", false, "Can't find file"));
        } else {
            response.setServiceStatus(new ServiceStatus("200", true, ""));
        }

        List<DigitalDocumentResponse> digitalDocumentResponseList = new ArrayList<>();

        digitalDocumentList.forEach(digitalDocument -> {
            digitalDocumentResponseList.add(new DigitalDocumentResponse(digitalDocument.getType()
                    , "Y".equals(digitalDocument.getRequired())
                    , digitalDocument.getTemplateLocation()
                    , digitalDocument.getDescription()));
        });

        response.setDigitalDocumentResponseList(digitalDocumentResponseList);
        return response;
    }
}
