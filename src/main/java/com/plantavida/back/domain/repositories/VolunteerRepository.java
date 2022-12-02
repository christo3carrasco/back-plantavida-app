package com.plantavida.back.domain.repositories;

import com.plantavida.back.domain.entities.User;
import com.plantavida.back.domain.entities.Volunteer;

import java.util.List;
import java.util.Optional;

public interface VolunteerRepository {
    Volunteer createVolunteer(Volunteer volunteer);

    List<Volunteer> readVolunteer();

    void deleteVolunteer(Integer id);

    Optional<Volunteer> readVolunteerId(Integer id);

    List<Volunteer> readVolunteerConfirmed(Integer confirmed);

    List<Volunteer> readVolunteerUserAndAssistance(User user, Integer assistance);
}
