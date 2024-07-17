package com.crea.storage.model;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
public class Sector {

    @Id
    private Long id;

    @NotBlank
    private String name;

    private Set<User> users;

    private Set<Document> stores;

    @NotBlank
    private String folder;
}
