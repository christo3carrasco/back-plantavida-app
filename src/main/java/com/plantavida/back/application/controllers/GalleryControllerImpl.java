package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.entities.Gallery;
import com.plantavida.back.domain.services.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api")
public class GalleryControllerImpl implements GalleryController {
    @Autowired
    private GalleryService galleryService;

    @Override
    public Gallery postGallery(Gallery gallery) {
        return galleryService.createGalley(gallery);
    }

    @Override
    public List<Gallery> getGallery() {
        return galleryService.readGallery();
    }
}
