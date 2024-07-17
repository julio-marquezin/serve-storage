package com.crea.storage.service;

import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final ConversionService conversionService;
    private final StorageService storageService;
    private final FTPService ftpservice;

    public DocumentService(ConversionService conversionService, StorageService storageService, FTPService ftpservice) {
        this.conversionService = conversionService;
        this.storageService = storageService;
        this.ftpservice = ftpservice;
    }


}
