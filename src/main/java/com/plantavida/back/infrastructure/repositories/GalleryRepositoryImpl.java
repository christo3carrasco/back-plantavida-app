package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.Gallery;
import com.plantavida.back.domain.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GalleryRepositoryImpl implements GalleryRepository {
    @Autowired
    GalleryJpaRepository db;

    @Override
    public Gallery createGalley(Gallery gallery) {
        return db.save(gallery);
    }

    @Override
    public List<Gallery> readGallery() {
        return db.findAll();
    }
}
