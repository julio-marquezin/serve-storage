package com.crea.storage.model;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Computer {

    @Id
    private UUID id;

    @NotBlank
    private String host;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String folder;

}
