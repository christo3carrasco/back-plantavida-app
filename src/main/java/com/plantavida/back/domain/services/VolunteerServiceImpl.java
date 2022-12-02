package com.plantavida.back.domain.services;

import com.plantavida.back.domain.dto.VolunteerDTO;
import com.plantavida.back.domain.entities.User;
import com.plantavida.back.domain.entities.Volunteer;
import com.plantavida.back.infrastructure.repositories.VolunteerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    private VolunteerRepositoryImpl volunteerRepository;

    @Override
    public Volunteer createVolunteer(Volunteer volunteer) {
        return volunteerRepository.createVolunteer(volunteer);
    }

    @Override
    public List<Volunteer> readVolunteer() {
        return volunteerRepository.readVolunteer();
    }

    @Override
    public Volunteer updateVolunteer(Integer id, VolunteerDTO volunteerDTO) {
        Volunteer updateVolunteer = volunteerRepository.readVolunteerId(id).orElse(null);
        if (updateVolunteer != null) {
            updateVolunteer.setEvent(volunteerDTO.getEvent());
            updateVolunteer.setUser(volunteerDTO.getUser());
            updateVolunteer.setConfirmed(volunteerDTO.getConfirmed());
            updateVolunteer.setAssistance(volunteerDTO.getAssistance());
        }
        return volunteerRepository.createVolunteer(updateVolunteer);
    }

    @Override
    public void deleteVolunteer(Integer id) {
        volunteerRepository.deleteVolunteer(id);
    }

    @Override
    public Optional<Volunteer> readVolunteerId(Integer id) {
        return volunteerRepository.readVolunteerId(id);
    }

    @Override
    public List<Volunteer> readVolunteerConfirmed(Integer confirmed) {
        return volunteerRepository.readVolunteerConfirmed(confirmed);
    }

    @Override
    public List<Volunteer> readVolunteerUserAndAssistance(User user, Integer assistance) {
        return volunteerRepository.readVolunteerUserAndAssistance(user, assistance);
    }
}
