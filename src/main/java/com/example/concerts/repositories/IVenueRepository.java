package com.example.concerts.repositories;

import com.example.concerts.entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVenueRepository extends JpaRepository<Venue, Integer> {
}