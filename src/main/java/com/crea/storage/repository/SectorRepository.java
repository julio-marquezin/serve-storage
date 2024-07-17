package com.crea.storage.repository;

import com.crea.storage.model.Sector;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SectorRepository extends MongoRepository<Sector, Long> {
}
