package com.example.concerts.mappers;

import com.example.concerts.entities.Event;
import com.example.concerts.models.EventModel;
import com.example.concerts.models.EventPageModel;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.List;

public class EventMapper {
    public static EventModel toModel(Event entity) {
        return EventModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .eventDate(entity.getEventDate())
                .description(entity.getDescription())
                .ticketPrice(entity.getTicketPrice())
                .venueId(entity.getVenue() != null ? entity.getVenue().getId() : null)
                .venueName(entity.getVenue() != null ? entity.getVenue().getName() : null)
                .venueCity(entity.getVenue() != null ? entity.getVenue().getCity() : null)
                .artistId(entity.getArtist() != null ? entity.getArtist().getId() : null)
                .artistName(entity.getArtist() != null ? entity.getArtist().getName() : null)
                .build();
    }

    public static List<EventModel> toModelList(List<Event> entities) {
        List<EventModel> list = new ArrayList<>();
        for (Event entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static EventPageModel toPageModel(Page<Event> page) {
        return EventPageModel.builder()
                .events(toModelList(page.getContent()))
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .build();
    }
}