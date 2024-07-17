package com.crea.storage.controller;

import com.crea.storage.model.Sector;
import com.crea.storage.repository.SectorRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    private final SectorRepository sectorRepository;

    @Autowired
    public SectorController(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    @PostMapping
    private ResponseEntity<Sector> createSector(@RequestBody @Valid Sector sector) {
        return ResponseEntity.ok(sectorRepository.save(sector));
    }

}
