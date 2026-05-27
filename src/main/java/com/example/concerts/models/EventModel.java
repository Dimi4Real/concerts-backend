package com.example.concerts.models;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class EventModel {
    private Integer id;
    private String name;
    private LocalDateTime eventDate;
    private String description;
    private Double ticketPrice;
    private Integer venueId;
    private String venueName;
    private String venueCity;
    private Integer artistId;
    private String artistName;
}