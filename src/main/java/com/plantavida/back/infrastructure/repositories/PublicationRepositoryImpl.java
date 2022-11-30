package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.Publication;
import com.plantavida.back.domain.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicationRepositoryImpl implements PublicationRepository {
    @Autowired
    PublicationJpaRepository db;

    @Override
    public Publication createPublication(Publication publication) {
        return db.save(publication);
    }

    @Override
    public List<Publication> readPublication() {
        return db.findAll();
    }
}