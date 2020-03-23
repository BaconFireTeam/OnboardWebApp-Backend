package com.baconfire.onboardwebapp.service.FileStorage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String storeFile(MultipartFile file, int employeeID, String type);

    Resource loadFileAsResource(String fileName);
}
