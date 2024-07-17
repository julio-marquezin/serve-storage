package com.crea.storage.repository;

import com.crea.storage.model.Sector;
import com.crea.storage.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    Optional<User> findByPhoneNumber(String phoneNumber);

    List<User> findBySector(Sector sector);

    boolean deleteByEmail(String email);

    boolean deleteByPhoneNumber(String phoneNumber);

    boolean deleteBySector(Sector sector);

}
