package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.entities.Publication;
import com.plantavida.back.domain.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api")
public class PublicationControllerImpl implements PublicationController {
    @Autowired
    private PublicationService publicationService;

    @Override
    public Publication postPublication(Publication publication) {
        return publicationService.createPublication(publication);
    }

    @Override
    public List<Publication> getPublication() {
        return publicationService.readPublication();
    }
}