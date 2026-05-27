package com.example.concerts.controllers;

import com.example.concerts.models.VenueModel;
import com.example.concerts.services.IVenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/venue")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VenueController {

    private final IVenueService venueService;

    @GetMapping("/get-list")
    public ResponseEntity<List<VenueModel>> getList() {
        return ResponseEntity.ok(venueService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<VenueModel> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(venueService.findById(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<VenueModel> create(@RequestBody VenueModel model) {
        return new ResponseEntity<>(venueService.create(model), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<VenueModel> update(@RequestBody VenueModel model) {
        return ResponseEntity.ok(venueService.update(model));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        venueService.delete(id);
        return ResponseEntity.noContent().build();
    }
}