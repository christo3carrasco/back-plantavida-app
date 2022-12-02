package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.dto.EventDTO;
import com.plantavida.back.domain.entities.Event;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface EventController {
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    @PostMapping(value = "/event", produces = {"application/json"}, consumes = {"application/json"})
    Event postEvent(@RequestBody Event event);

    @GetMapping(value = "/event", produces = {"application/json"})
    List<Event> getEvent();

    @GetMapping(value = "/event/{id}", produces = {"application/json"})
    Optional<Event> getEvent(@PathVariable(value = "id") Integer id);

    @PreAuthorize("hasRole('ADMIN_ROLE')")
    @PutMapping(value = "/event/{id}", produces = {"application/json"})
    Event putEvent(@PathVariable(value = "id") Integer id, @RequestBody EventDTO eventDTO);

    @PreAuthorize("hasRole('ADMIN_ROLE')")
    @DeleteMapping(value = "/event/{id}")
    void deleteEvent(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/event/on/{status}", produces = {"application/json"})
    List<Event> isEvent(@PathVariable(value = "status") Integer status);
}
