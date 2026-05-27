package com.example.concerts.controllers;

import com.example.concerts.models.ArtistModel;
import com.example.concerts.services.IArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/artist")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ArtistController {

    private final IArtistService artistService;

    @GetMapping("/get-list")
    public ResponseEntity<List<ArtistModel>> getList() {
        return ResponseEntity.ok(artistService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ArtistModel> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(artistService.findById(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ArtistModel> create(@RequestBody ArtistModel model) {
        return new ResponseEntity<>(artistService.create(model), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ArtistModel> update(@RequestBody ArtistModel model) {
        return ResponseEntity.ok(artistService.update(model));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        artistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}