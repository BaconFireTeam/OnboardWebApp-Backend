package com.baconfire.onboardwebapp.controller;

import com.baconfire.onboardwebapp.dao.DigitalDocument.DigitalDocumentDAO;
import com.baconfire.onboardwebapp.dao.PersonalDocument.PersonalDocumentDAO;
import com.baconfire.onboardwebapp.domain.DigitalDocument;
import com.baconfire.onboardwebapp.domain.PersonalDocument;
import com.baconfire.onboardwebapp.restful.domain.Files.GetDocumentsListResponse;
import com.baconfire.onboardwebapp.restful.domain.Files.UploadFileResponse;
import com.baconfire.onboardwebapp.service.FileStorage.DigitalDocumentService;
import com.baconfire.onboardwebapp.service.FileStorage.FileStorageService;
import com.baconfire.onboardwebapp.service.FileStorage.PersonalDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private FileStorageService fileStorageServiceImpl;
    private PersonalDocumentService personalDocumentServiceImpl;
    private DigitalDocumentService digitalDocumentServiceImpl;

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

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageServiceImpl.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(fileName)
                .toUriString();

//        this.personalDocumentServiceImpl.storeFile(fileName, fileDownloadUri);

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize(), true);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageServiceImpl.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/employee/onboarding/getFiles")
    public GetDocumentsListResponse getFiles() {
        // request contains employee id
        // personal document table
        // table: title, path
        GetDocumentsListResponse response = new GetDocumentsListResponse();

        return response;
    }

    @GetMapping("/getDigitalDocument")
    public GetDocumentsListResponse getDigitalDocuments() {
        GetDocumentsListResponse response = new GetDocumentsListResponse();

        return response;
    }
}
