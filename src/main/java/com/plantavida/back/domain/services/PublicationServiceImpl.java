package com.plantavida.back.domain.services;

import com.plantavida.back.domain.entities.Publication;
import com.plantavida.back.infrastructure.repositories.PublicationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {
    @Autowired
    private PublicationRepositoryImpl publicationRepository;

    @Override
    public Publication createPublication(Publication publication) {
        return publicationRepository.createPublication(publication);
    }

    @Override
    public List<Publication> readPublication() {
        return publicationRepository.readPublication();
    }
}