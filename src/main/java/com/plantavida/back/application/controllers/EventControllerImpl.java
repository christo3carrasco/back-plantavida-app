package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.dto.EventDTO;
import com.plantavida.back.domain.entities.Event;
import com.plantavida.back.domain.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api")
public class EventControllerImpl implements EventController {
    @Autowired
    private EventService eventService;

    @Override
    public Event postEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setName(eventDTO.getName());
        event.setPlace(eventDTO.getPlace());
        event.setTimeEv(eventDTO.getTimeEv());
        event.setDateEv(eventDTO.getDateEv());
        event.setStatus(eventDTO.getStatus());
        return eventService.createEvent(event);
    }

    @Override
    public List<Event> getEvent() {
        return eventService.readEvent();
    }

    @Override
    public Optional<Event> getEvent(Integer id) {
        return eventService.readEventId(id);
    }

    @Override
    public Event putEvent(Integer id, EventDTO eventDTO) {
        return eventService.updateEvent(id, eventDTO);
    }

    @Override
    public void deleteEvent(Integer id) {
        eventService.deleteEvent(id);
    }

    @Override
    public List<Event> isEvent(Integer status) {
        return eventService.readEventStatus(status);
    }
}
