package com.crea.storage.service;

import com.crea.storage.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {

    private final FTPService ftpService;

    @Autowired
    public StorageService(FTPService ftpService) {
        this.ftpService = ftpService;
    }



    public boolean uploadDocument(Document document, MultipartFile file) throws IOException {

        boolean stored = ftpService.storeFile(file.getOriginalFilename(), file.getInputStream());

        if (stored) {
//            document.setFile();
        }

        return stored;
    }

}
