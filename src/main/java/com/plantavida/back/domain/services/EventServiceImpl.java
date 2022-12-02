package com.plantavida.back.domain.services;

import com.plantavida.back.domain.dto.EventDTO;
import com.plantavida.back.domain.entities.Event;
import com.plantavida.back.infrastructure.repositories.EventRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepositoryImpl eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.createEvent(event);
    }

    @Override
    public List<Event> readEvent() {
        return eventRepository.readEvent();
    }

    @Override
    public Event updateEvent(Integer id, EventDTO eventDTO) {
        Event updateEvent = eventRepository.readEventId(id).orElse(null);
        if (updateEvent != null) {
            updateEvent.setName(eventDTO.getName());
            updateEvent.setPlace(eventDTO.getPlace());
            updateEvent.setTimeEv(eventDTO.getTimeEv());
            updateEvent.setDateEv(eventDTO.getDateEv());
            updateEvent.setStatus(eventDTO.getStatus());
        }
        return eventRepository.createEvent(updateEvent);
    }

    @Override
    public void deleteEvent(Integer id) {
        eventRepository.deleteEvent(id);
    }

    @Override
    public Optional<Event> readEventId(Integer id) {
        return eventRepository.readEventId(id);
    }

    @Override
    public List<Event> readEventStatus(Integer status) {
        return eventRepository.readEventStatus(status);
    }
}
