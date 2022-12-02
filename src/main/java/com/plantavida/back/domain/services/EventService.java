package com.plantavida.back.domain.services;

import com.plantavida.back.domain.dto.EventDTO;
import com.plantavida.back.domain.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event createEvent(Event event);

    List<Event> readEvent();

    Event updateEvent(Integer id, EventDTO eventDTO);

    void deleteEvent(Integer id);

    Optional<Event> readEventId(Integer id);

    List<Event> readEventStatus(Integer status);
}
