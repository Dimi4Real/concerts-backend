package com.example.concerts.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenreModel {
    private Integer id;
    private String name;
}