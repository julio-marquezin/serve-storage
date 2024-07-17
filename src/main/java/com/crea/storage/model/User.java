package com.crea.storage.model;

import com.crea.storage.validator.Password;
import com.crea.storage.validator.PhoneNumber;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class User {

    @Id
    private UUID id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @Indexed(unique = true)
    private String email;

    @Password
    private String password;

    @PhoneNumber
    @Indexed(unique = true)
    private String phoneNumber;

    @NotEmpty
    private Set<Role> roles;

    private Set<Document> documents;

    @NotNull
    private Sector sector;

    public boolean hasRole(User user, Role role) {
        return user.getRoles().contains(role);
    }

    public enum Role {
        TRAINEE,
        EMPLOYEE,
        SECRETARY,
        BOSS,
        CABINET,
        ADMIN
    }
}
