package com.crea.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class StorageServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageServeApplication.class, args);
    }

}
