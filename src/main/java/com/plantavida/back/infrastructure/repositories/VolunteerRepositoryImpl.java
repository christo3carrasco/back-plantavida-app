package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.User;
import com.plantavida.back.domain.entities.Volunteer;
import com.plantavida.back.domain.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VolunteerRepositoryImpl implements VolunteerRepository {
    @Autowired
    VolunteerJpaRepository db;

    @Override
    public Volunteer createVolunteer(Volunteer volunteer) {
        return db.save(volunteer);
    }

    @Override
    public List<Volunteer> readVolunteer() {
        return db.findAll();
    }

    @Override
    public void deleteVolunteer(Integer id) {
        db.deleteById(id);
    }

    @Override
    public Optional<Volunteer> readVolunteerId(Integer id) {
        return db.findById(id);
    }

    @Override
    public List<Volunteer> readVolunteerConfirmed(Integer confirmed) {
        return db.findByConfirmed(confirmed);
    }

    @Override
    public List<Volunteer> readVolunteerUserAndAssistance(User user, Integer assistance) {
        return db.findByUserAndAssistance(user, assistance);
    }
}
