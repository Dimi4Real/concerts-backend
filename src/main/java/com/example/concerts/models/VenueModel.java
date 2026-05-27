package com.example.concerts.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VenueModel {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private Integer capacity;
}