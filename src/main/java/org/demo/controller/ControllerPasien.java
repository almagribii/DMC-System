package org.demo.controller;

import org.demo.model.Pasien;
import org.demo.repository.RepositoryPasien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pasien")
public class ControllerPasien {
    private final RepositoryPasien repositoryPasien;

    @Autowired
    public ControllerPasien(RepositoryPasien repositoryPasien){
        this.repositoryPasien = repositoryPasien;
    }

    @GetMapping
    public ResponseEntity<List<Pasien>> getAllPasien(){
        List<Pasien> pasienList = repositoryPasien.findAll();
        return ResponseEntity.ok(pasienList);
    }
}
