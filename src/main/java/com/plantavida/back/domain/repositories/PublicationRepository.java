package com.plantavida.back.domain.repositories;

import com.plantavida.back.domain.entities.Publication;

import java.util.List;

public interface PublicationRepository {
    Publication createPublication(Publication publication);

    List<Publication> readPublication();
}
