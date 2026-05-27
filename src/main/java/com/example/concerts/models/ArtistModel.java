package com.example.concerts.models;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class ArtistModel {
    private Integer id;
    private String name;
    private String bio;
    private List<GenreModel> genres;
}