package com.crea.storage.config;

import lombok.SneakyThrows;

import org.apache.tika.Tika;

import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.local.LocalConverter;
import org.jodconverter.local.office.LocalOfficeManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JodConverterConfig {

    @Value("${jodconverter.local.office-home}")
    private String officeHome;

    @Value("${jodconverter.local.host}")
    private String host;

    @Value("${jodconverter.local.port}")
    private int port;

    @SneakyThrows
    @Bean
    public OfficeManager officeManager() {
        LocalOfficeManager officeManager = LocalOfficeManager
                .builder()
                .officeHome(officeHome)
                .hostName(host)
                .portNumbers(port)
                .install()
                .build();

        officeManager.start();

        return officeManager;
    }

    @Bean
    public DocumentConverter documentConverter(OfficeManager officeManager) {
        return LocalConverter
                .builder()
                .officeManager(officeManager)
                .build();
    }

    @Bean
    public Tika tika() {
        return new Tika();
    }

}
