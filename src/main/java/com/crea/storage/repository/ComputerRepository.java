package com.crea.storage.repository;

import com.crea.storage.model.Computer;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ComputerRepository extends MongoRepository<Computer, UUID> {
}
