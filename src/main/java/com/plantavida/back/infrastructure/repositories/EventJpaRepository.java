package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventJpaRepository extends JpaRepository<Event, Integer> {
    List<Event> findByStatus(Integer status);
}
