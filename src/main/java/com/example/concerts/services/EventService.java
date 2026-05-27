package com.example.concerts.services;

import com.example.concerts.entities.Artist;
import com.example.concerts.entities.Event;
import com.example.concerts.entities.Venue;
import com.example.concerts.mappers.EventMapper;
import com.example.concerts.models.EventModel;
import com.example.concerts.models.EventPageModel;
import com.example.concerts.repositories.IArtistRepository;
import com.example.concerts.repositories.IEventRepository;
import com.example.concerts.repositories.IVenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {

    private final IEventRepository eventRepository;
    private final IArtistRepository artistRepository;
    private final IVenueRepository venueRepository;

    @Override
    public List<EventModel> findAll() {
        return EventMapper.toModelList(eventRepository.findAll());
    }

    @Override
    public EventPageModel findPagedList(PageRequest pageRequest) {
        return EventMapper.toPageModel(eventRepository.findAll(pageRequest));
    }

    @Override
    public EventModel findById(Integer id) {
        Event event = eventRepository.findById(id).orElseThrow();
        return EventMapper.toModel(event);
    }

    @Override
    public EventModel create(EventModel model) {
        Event event = new Event();
        event.setName(model.getName());
        event.setEventDate(model.getEventDate());
        event.setDescription(model.getDescription());
        event.setTicketPrice(model.getTicketPrice());

        // Povežemo event sa artistom iz baze
        Artist artist = artistRepository.findById(model.getArtistId()).orElseThrow();
        event.setArtist(artist);

        // Povežemo event sa venueom iz baze
        Venue venue = venueRepository.findById(model.getVenueId()).orElseThrow();
        event.setVenue(venue);

        return EventMapper.toModel(eventRepository.save(event));
    }

    @Override
    public EventModel update(EventModel model) {
        Event event = eventRepository.findById(model.getId()).orElseThrow();
        event.setName(model.getName());
        event.setEventDate(model.getEventDate());
        event.setDescription(model.getDescription());
        event.setTicketPrice(model.getTicketPrice());

        Artist artist = artistRepository.findById(model.getArtistId()).orElseThrow();
        event.setArtist(artist);

        Venue venue = venueRepository.findById(model.getVenueId()).orElseThrow();
        event.setVenue(venue);

        return EventMapper.toModel(eventRepository.save(event));
    }

    @Override
    public void delete(Integer id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventModel> findByArtist(Integer artistId) {
        return EventMapper.toModelList(eventRepository.findByArtistId(artistId));
    }

    @Override
    public List<EventModel> findByVenue(Integer venueId) {
        return EventMapper.toModelList(eventRepository.findByVenueId(venueId));
    }
}