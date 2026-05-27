package com.example.concerts.services;

import com.example.concerts.models.VenueModel;
import java.util.List;

public interface IVenueService {
    List<VenueModel> findAll();
    VenueModel findById(Integer id);
    VenueModel create(VenueModel model);
    VenueModel update(VenueModel model);
    void delete(Integer id);
}