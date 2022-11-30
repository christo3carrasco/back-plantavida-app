package com.plantavida.back.domain.services;

import com.plantavida.back.domain.entities.Gallery;

import java.util.List;

public interface GalleryService {
    Gallery createGalley(Gallery gallery);

    List<Gallery> readGallery();
}
