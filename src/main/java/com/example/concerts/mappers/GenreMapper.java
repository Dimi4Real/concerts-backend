package com.example.concerts.mappers;

import com.example.concerts.entities.Genre;
import com.example.concerts.models.GenreModel;
import java.util.ArrayList;
import java.util.List;

public class GenreMapper {
    public static GenreModel toModel(Genre entity) {
        return GenreModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static List<GenreModel> toModelList(List<Genre> entities) {
        List<GenreModel> list = new ArrayList<>();
        for (Genre entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static Genre toEntity(GenreModel model) {
        Genre genre = new Genre();
        genre.setId(model.getId());
        genre.setName(model.getName());
        return genre;
    }
}