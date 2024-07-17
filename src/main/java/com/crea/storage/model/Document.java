package com.crea.storage.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Document {

    @Id
    private UUID id;

    @CreatedBy
    private User owner;

    @NotBlank
    private String name;

    @NotBlank
    private String contentType;

    @NotBlank
    private String file;

    @NotNull
    private Computer storageUnit;

    @PastOrPresent
    private LocalDateTime createdAt;

}
