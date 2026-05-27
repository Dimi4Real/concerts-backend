package com.example.concerts.mappers;

import com.example.concerts.entities.Artist;
import com.example.concerts.models.ArtistModel;
import java.util.ArrayList;
import java.util.List;

public class ArtistMapper {
    public static ArtistModel toModel(Artist entity) {
        return ArtistModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .bio(entity.getBio())
                .genres(entity.getGenres() != null ?
                        GenreMapper.toModelList(entity.getGenres()) : new ArrayList<>())
                .build();
    }

    public static List<ArtistModel> toModelList(List<Artist> entities) {
        List<ArtistModel> list = new ArrayList<>();
        for (Artist entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static Artist toEntity(ArtistModel model) {
        Artist artist = new Artist();
        artist.setId(model.getId());
        artist.setName(model.getName());
        artist.setBio(model.getBio());
        return artist;
    }
}