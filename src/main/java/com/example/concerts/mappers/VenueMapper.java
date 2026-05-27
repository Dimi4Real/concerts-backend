package com.example.concerts.mappers;

import com.example.concerts.entities.Venue;
import com.example.concerts.models.VenueModel;
import java.util.ArrayList;
import java.util.List;

public class VenueMapper {
    public static VenueModel toModel(Venue entity) {
        return VenueModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .city(entity.getCity())
                .capacity(entity.getCapacity())
                .build();
    }

    public static List<VenueModel> toModelList(List<Venue> entities) {
        List<VenueModel> list = new ArrayList<>();
        for (Venue entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static Venue toEntity(VenueModel model) {
        Venue venue = new Venue();
        venue.setId(model.getId());
        venue.setName(model.getName());
        venue.setAddress(model.getAddress());
        venue.setCity(model.getCity());
        venue.setCapacity(model.getCapacity());
        return venue;
    }
}