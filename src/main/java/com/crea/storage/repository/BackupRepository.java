package com.crea.storage.repository;

import com.crea.storage.model.Backup;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BackupRepository extends MongoRepository<Backup, UUID> {
}
