package com.crea.storage.controller;

import com.crea.storage.service.AuthService;
import com.crea.storage.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final MailService mailService;

    @Autowired
    public AuthController(AuthService authService, MailService mailService) {
        this.authService = authService;
        this.mailService = mailService;
    }

    @GetMapping("/login")
    public String login() {
        return "User logged in successfully";
    }

    @GetMapping("/login/oauth2/code/{registrationId}")
    public String loginOkta(@PathVariable String registrationId, @AuthenticationPrincipal OAuth2User oauth2User) {
        return "User logged in successfully via Okta";
    }

    @GetMapping("/register")
    public String register() {
        return "User registered successfully";
    }

    @GetMapping
    public String registerOkta(@AuthenticationPrincipal OAuth2User oauth2User) {
        authService.save(oauth2User);
        return "";
    }

    @GetMapping("/logout")
    public String logout() {
        return "User logged out successfully";
    }

    @GetMapping("/verify")
    public String verifyToken() {
        return "Token is valid";
    }

    @GetMapping("/refresh")
    public String refreshToken() {
        return "Refreshed token successfully";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "Password reset link sent successfully";
    }

    @GetMapping("/reset-password")
    public String resetPassword() {
        return "Password reset successfully";
    }

    @GetMapping("/change-password")
    public String changePassword() {
        return "Password changed successfully";
    }
}
