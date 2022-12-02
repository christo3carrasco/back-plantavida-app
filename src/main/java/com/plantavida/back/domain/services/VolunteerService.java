package com.plantavida.back.domain.services;

import com.plantavida.back.domain.dto.VolunteerDTO;
import com.plantavida.back.domain.entities.User;
import com.plantavida.back.domain.entities.Volunteer;

import java.util.List;
import java.util.Optional;

public interface VolunteerService {
    Volunteer createVolunteer(Volunteer volunteer);

    List<Volunteer> readVolunteer();

    Volunteer updateVolunteer(Integer id, VolunteerDTO volunteerDTO);

    void deleteVolunteer(Integer id);

    Optional<Volunteer> readVolunteerId(Integer id);

    List<Volunteer> readVolunteerConfirmed(Integer confirmed);

    List<Volunteer> readVolunteerUserAndAssistance(User user, Integer assistance);
}
