package com.example.concerts.services;

import com.example.concerts.models.ArtistModel;
import java.util.List;

public interface IArtistService {
    List<ArtistModel> findAll();
    ArtistModel findById(Integer id);
    ArtistModel create(ArtistModel model);
    ArtistModel update(ArtistModel model);
    void delete(Integer id);
}