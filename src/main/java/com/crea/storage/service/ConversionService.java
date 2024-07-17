package com.crea.storage.service;

import org.apache.tika.Tika;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;

import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.document.DefaultDocumentFormatRegistry;
import org.jodconverter.core.document.DocumentFormat;
import org.jodconverter.core.office.OfficeException;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

@Service
public class ConversionService {

    private final DocumentConverter documentConverter;
    private final Tika tika;

    public ConversionService(DocumentConverter documentConverter, Tika tika) {
        this.documentConverter = documentConverter;
        this.tika = tika;
    }

    public void convertDocument(InputStream sourceFile, OutputStream targetFile, DocumentFormat targetFormat) throws OfficeException {
        documentConverter.convert(sourceFile).to(targetFile).as(targetFormat).execute();
    }

    public DocumentFormat identifyFormat(String name) throws MimeTypeException {
        String mimeType = tika.detect(name);
        String extension = MimeTypes.getDefaultMimeTypes().forName(mimeType).getExtension();

        return DefaultDocumentFormatRegistry.getFormatByExtension(extension);
    }

}
