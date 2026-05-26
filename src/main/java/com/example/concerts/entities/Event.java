package com.example.concerts.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    @Column(name = "description")
    private String description;

    @Column(name = "ticket_price")
    private Double ticketPrice;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    @JsonManagedReference
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonManagedReference
    private Artist artist;
}