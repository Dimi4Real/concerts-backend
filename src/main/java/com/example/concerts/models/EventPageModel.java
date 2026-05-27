package com.example.concerts.models;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class EventPageModel {
    private List<EventModel> events;
    private int totalPages;
    private Long totalElements;
}