package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.dto.VolunteerDTO;
import com.plantavida.back.domain.entities.Volunteer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface VolunteerController {
    @PostMapping(value = "/volunteer", produces = {"application/json"}, consumes = {"application/json"})
    Volunteer postVolunteer(@RequestBody VolunteerDTO volunteerDTO);

    @GetMapping(value = "/volunteer", produces = {"application/json"})
    List<Volunteer> getVolunteer();

    @GetMapping(value = "/volunteer/{id}", produces = {"application/json"})
    Optional<Volunteer> getVolunteer(@PathVariable(value = "id") Integer id);

    @PutMapping(value = "/volunteer/{id}", produces = {"application/json"})
    Volunteer putVolunteer(@PathVariable(value = "id") Integer id, @RequestBody VolunteerDTO volunteerDTO);

    @PreAuthorize("hasRole('ADMIN_ROLE')")
    @DeleteMapping(value = "/volunteer/{id}")
    void deleteVolunteer(@PathVariable(value = "id") Integer id);

    @PreAuthorize("hasRole('ADMIN_ROLE')")
    @GetMapping(value = "/volunteer/xp/{confirmed}", produces = {"application/json"})
    List<Volunteer> listVolunteer(@PathVariable(value = "confirmed") Integer confirmed);

    @GetMapping(value = "/volunteer/xc/{id}", produces = {"application/json"})
    List<Volunteer> isVolunteer(@PathVariable(value = "id") Integer id);
}
