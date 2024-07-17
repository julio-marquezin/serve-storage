package com.crea.storage.controller;

import com.crea.storage.service.ConversionService;
import com.crea.storage.service.DocumentService;
import com.crea.storage.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    private final StorageService storageService;
    private final DocumentService documentService;
    private final ConversionService conversionService;

    @Autowired
    public DocumentController(StorageService storageService, DocumentService documentService, ConversionService conversionService) {
        this.storageService = storageService;
        this.documentService = documentService;
        this.conversionService = conversionService;
    }



}
