package org.demo.controller;

import org.demo.model.Dokter;
import org.demo.repository.RepositoryDokter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dokter")
public class ControllerDokter {
    private final RepositoryDokter repositoryDokter;

    @Autowired
    public ControllerDokter(RepositoryDokter repositoryDokter){
        this.repositoryDokter = repositoryDokter;
    }

    @GetMapping
    public ResponseEntity<List<Dokter>> getAllDokter(){
        List<Dokter> dokterList = repositoryDokter.findAll();
        return ResponseEntity.ok(dokterList);
    }
}
