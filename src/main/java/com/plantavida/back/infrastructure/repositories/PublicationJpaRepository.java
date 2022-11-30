package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationJpaRepository extends JpaRepository<Publication, Integer> {
}
