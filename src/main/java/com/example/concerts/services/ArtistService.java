package com.example.concerts.services;

import com.example.concerts.entities.Artist;
import com.example.concerts.entities.Genre;
import com.example.concerts.mappers.ArtistMapper;
import com.example.concerts.models.ArtistModel;
import com.example.concerts.repositories.IArtistRepository;
import com.example.concerts.repositories.IGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService implements IArtistService {

    private final IArtistRepository artistRepository;
    private final IGenreRepository genreRepository;

    @Override
    public List<ArtistModel> findAll() {
        return ArtistMapper.toModelList(artistRepository.findAll());
    }

    @Override
    public ArtistModel findById(Integer id) {
        Artist artist = artistRepository.findById(id).orElseThrow();
        return ArtistMapper.toModel(artist);
    }

    @Override
    public ArtistModel create(ArtistModel model) {
        Artist artist = ArtistMapper.toEntity(model);

        // Dodajemo zanrove artisti (ManyToMany)
        if (model.getGenres() != null) {
            List<Genre> genres = new ArrayList<>();
            for (var genreModel : model.getGenres()) {
                Genre genre = genreRepository.findById(genreModel.getId()).orElseThrow();
                genres.add(genre);
            }
            artist.setGenres(genres);
        }

        return ArtistMapper.toModel(artistRepository.save(artist));
    }

    @Override
    public ArtistModel update(ArtistModel model) {
        Artist artist = artistRepository.findById(model.getId()).orElseThrow();
        artist.setName(model.getName());
        artist.setBio(model.getBio());

        if (model.getGenres() != null) {
            List<Genre> genres = new ArrayList<>();
            for (var genreModel : model.getGenres()) {
                Genre genre = genreRepository.findById(genreModel.getId()).orElseThrow();
                genres.add(genre);
            }
            artist.setGenres(genres);
        }

        return ArtistMapper.toModel(artistRepository.save(artist));
    }

    @Override
    public void delete(Integer id) {
        artistRepository.deleteById(id);
    }
}