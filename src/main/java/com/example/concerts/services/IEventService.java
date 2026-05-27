package com.example.concerts.services;

import com.example.concerts.models.EventModel;
import com.example.concerts.models.EventPageModel;
import org.springframework.data.domain.PageRequest;
import java.util.List;

public interface IEventService {
    List<EventModel> findAll();
    EventPageModel findPagedList(PageRequest pageRequest);
    EventModel findById(Integer id);
    EventModel create(EventModel model);
    EventModel update(EventModel model);
    void delete(Integer id);
    List<EventModel> findByArtist(Integer artistId);
    List<EventModel> findByVenue(Integer venueId);
}