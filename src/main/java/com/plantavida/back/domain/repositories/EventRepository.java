package com.plantavida.back.domain.repositories;

import com.plantavida.back.domain.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    Event createEvent(Event event);

    List<Event> readEvent();

    void deleteEvent(Integer id);

    Optional<Event> readEventId(Integer id);

    List<Event> readEventStatus(Integer status);
}
