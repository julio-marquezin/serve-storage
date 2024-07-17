package com.crea.storage.repository;

import com.crea.storage.model.Document;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface DocumentRepository extends MongoRepository<Document, UUID> {
}
