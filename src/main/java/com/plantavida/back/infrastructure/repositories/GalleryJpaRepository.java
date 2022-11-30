package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryJpaRepository extends JpaRepository<Gallery, Integer> {
}
