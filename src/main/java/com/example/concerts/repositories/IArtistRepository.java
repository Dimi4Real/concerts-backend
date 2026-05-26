package com.example.concerts.repositories;

import com.example.concerts.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistRepository extends JpaRepository<Artist, Integer> {
}