package com.example.concerts.controllers;

import com.example.concerts.entities.Genre;
import com.example.concerts.models.GenreModel;
import com.example.concerts.mappers.GenreMapper;
import com.example.concerts.repositories.IGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GenreController {

    private final IGenreRepository genreRepository;

    @GetMapping("/get-list")
    public ResponseEntity<List<GenreModel>> getList() {
        return ResponseEntity.ok(
                GenreMapper.toModelList(genreRepository.findAll())
        );
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GenreModel> create(@RequestBody GenreModel model) {
        Genre genre = GenreMapper.toEntity(model);
        return new ResponseEntity<>(
                GenreMapper.toModel(genreRepository.save(genre)),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        genreRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}