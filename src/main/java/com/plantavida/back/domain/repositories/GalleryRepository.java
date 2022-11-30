package com.plantavida.back.domain.repositories;

import com.plantavida.back.domain.entities.Gallery;

import java.util.List;

public interface GalleryRepository {
    Gallery createGalley(Gallery gallery);

    List<Gallery> readGallery();
}
