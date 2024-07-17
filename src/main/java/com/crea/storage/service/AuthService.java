package com.crea.storage.service;

import com.crea.storage.model.User;
import com.crea.storage.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(OAuth2User oauth2User) {
        User user = User.builder()
                .firstName(oauth2User.getAttribute("firstName"))
                .lastName(oauth2User.getAttribute("lastName"))
                .email(oauth2User.getAttribute("email"))
                .password(oauth2User.getAttribute("password"))
                .phoneNumber(oauth2User.getAttribute("phoneNumber"))
                .build();

        userRepository.insert(user);
    }

    public void update(OAuth2User oAuth2User) {
        User user = User.builder()
                .firstName(oAuth2User.getAttribute("firstName"))
                .lastName(oAuth2User.getAttribute("lastName"))
                .email(oAuth2User.getAttribute("email"))
                .password(oAuth2User.getAttribute("password"))
                .phoneNumber(oAuth2User.getAttribute("phoneNumber"))
                .build();

        userRepository.save(user);
    }

}
