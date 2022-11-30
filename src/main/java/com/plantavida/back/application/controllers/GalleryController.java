package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.entities.Gallery;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GalleryController {
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    @PostMapping(value = "/gallery", produces = {"application/json"}, consumes = {"application/json"})
    Gallery postGallery(@RequestBody Gallery gallery);

    @GetMapping(value = "/gallery", produces = {"application/json"})
    List<Gallery> getGallery();
}
