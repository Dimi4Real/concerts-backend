package com.example.concerts.repositories;

import com.example.concerts.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IEventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByArtistId(Integer artistId);
    List<Event> findByVenueId(Integer venueId);
    Page<Event> findAll(Pageable pageable);
}