package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.Event;
import com.plantavida.back.domain.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EventRepositoryImpl implements EventRepository {
    @Autowired
    EventJpaRepository db;

    @Override
    public Event createEvent(Event event) {
        return db.save(event);
    }

    @Override
    public List<Event> readEvent() {
        return db.findAll();
    }

    @Override
    public void deleteEvent(Integer id) {
        db.deleteById(id);
    }

    @Override
    public Optional<Event> readEventId(Integer id) {
        return db.findById(id);
    }

    @Override
    public List<Event> readEventStatus(Integer status) {
        return db.findByStatus(status);
    }
}
