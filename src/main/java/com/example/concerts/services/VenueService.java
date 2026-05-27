package com.example.concerts.services;

import com.example.concerts.entities.Venue;
import com.example.concerts.mappers.VenueMapper;
import com.example.concerts.models.VenueModel;
import com.example.concerts.repositories.IVenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueService implements IVenueService {

    private final IVenueRepository venueRepository;

    @Override
    public List<VenueModel> findAll() {
        return VenueMapper.toModelList(venueRepository.findAll());
    }

    @Override
    public VenueModel findById(Integer id) {
        Venue venue = venueRepository.findById(id).orElseThrow();
        return VenueMapper.toModel(venue);
    }

    @Override
    public VenueModel create(VenueModel model) {
        Venue venue = VenueMapper.toEntity(model);
        return VenueMapper.toModel(venueRepository.save(venue));
    }

    @Override
    public VenueModel update(VenueModel model) {
        Venue venue = venueRepository.findById(model.getId()).orElseThrow();
        venue.setName(model.getName());
        venue.setAddress(model.getAddress());
        venue.setCity(model.getCity());
        venue.setCapacity(model.getCapacity());
        return VenueMapper.toModel(venueRepository.save(venue));
    }

    @Override
    public void delete(Integer id) {
        venueRepository.deleteById(id);
    }
}