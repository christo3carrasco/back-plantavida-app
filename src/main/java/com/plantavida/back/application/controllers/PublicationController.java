package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.entities.Publication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PublicationController {
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    @PostMapping(value = "/publication", produces = {"application/json"}, consumes = {"application/json"})
    Publication postPublication(@RequestBody Publication publication);

    @GetMapping(value = "/publication", produces = {"application/json"})
    List<Publication> getPublication();
}
