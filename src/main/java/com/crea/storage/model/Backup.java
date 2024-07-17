package com.crea.storage.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class Backup {

    @Id
    private UUID id;

    @CreatedBy
    private User user;

    @NotNull
    private Computer from;

    @NotNull
    private Computer to;

    @NotEmpty
    private Set<Document> documents;

    @CreatedDate
    private LocalDateTime timestamp;

}
