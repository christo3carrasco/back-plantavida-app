package com.plantavida.back.domain.services;

import com.plantavida.back.domain.entities.Gallery;
import com.plantavida.back.infrastructure.repositories.GalleryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    private GalleryRepositoryImpl galleryRepository;

    @Override
    public Gallery createGalley(Gallery gallery) {
        return galleryRepository.createGalley(gallery);
    }

    @Override
    public List<Gallery> readGallery() {
        return galleryRepository.readGallery();
    }
}
