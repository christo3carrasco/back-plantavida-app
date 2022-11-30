package com.plantavida.back.domain.services;

import com.plantavida.back.domain.entities.Publication;

import java.util.List;

public interface PublicationService {
    Publication createPublication(Publication publication);

    List<Publication> readPublication();
}
