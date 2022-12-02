package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.User;
import com.plantavida.back.domain.entities.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerJpaRepository extends JpaRepository<Volunteer, Integer> {
    List<Volunteer> findByConfirmed(Integer confirmed);

    List<Volunteer> findByUserAndAssistance(User user, Integer assistance);
}
