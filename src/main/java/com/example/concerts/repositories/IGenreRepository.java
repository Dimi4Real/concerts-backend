package com.example.concerts.repositories;

import com.example.concerts.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<Genre, Integer> {
}