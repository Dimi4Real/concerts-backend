package com.example.concerts.controllers;

import com.example.concerts.models.EventModel;
import com.example.concerts.models.EventPageModel;
import com.example.concerts.services.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EventController {

    private final IEventService eventService;

    // Svi mogu da vide evente
    @GetMapping("/get-list")
    public ResponseEntity<List<EventModel>> getList() {
        return ResponseEntity.ok(eventService.findAll());
    }

    // Paginacija
    @GetMapping("/get-page-list")
    public ResponseEntity<EventPageModel> getPageList(
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return ResponseEntity.ok(
                eventService.findPagedList(PageRequest.of(pageNumber, pageSize))
        );
    }

    // Jedan event po ID-u
    @GetMapping("/get/{id}")
    public ResponseEntity<EventModel> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventService.findById(id));
    }

    // Eventi po artisti
    @GetMapping("/get-by-artist/{artistId}")
    public ResponseEntity<List<EventModel>> getByArtist(@PathVariable Integer artistId) {
        return ResponseEntity.ok(eventService.findByArtist(artistId));
    }

    // Eventi po venuu
    @GetMapping("/get-by-venue/{venueId}")
    public ResponseEntity<List<EventModel>> getByVenue(@PathVariable Integer venueId) {
        return ResponseEntity.ok(eventService.findByVenue(venueId));
    }

    // Samo ADMIN moze da kreira event
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EventModel> create(@RequestBody EventModel model) {
        return new ResponseEntity<>(eventService.create(model), HttpStatus.CREATED);
    }

    // Samo ADMIN moze da menja event
    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EventModel> update(@RequestBody EventModel model) {
        return ResponseEntity.ok(eventService.update(model));
    }

    // Samo ADMIN moze da brise event
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}