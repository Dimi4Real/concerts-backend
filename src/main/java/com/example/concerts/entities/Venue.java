package com.example.concerts.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "venues")
@Data
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "capacity")
    private Integer capacity;

    @OneToMany(mappedBy = "venue")
    @JsonBackReference
    private List<Event> events;
}