package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.dto.VolunteerDTO;
import com.plantavida.back.domain.entities.User;
import com.plantavida.back.domain.entities.Volunteer;
import com.plantavida.back.domain.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api")
public class VolunteerControllerImpl implements VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    @Override
    public Volunteer postVolunteer(Volunteer volunteer) {
        return volunteerService.createVolunteer(volunteer);
    }

    @Override
    public List<Volunteer> getVolunteer() {
        return volunteerService.readVolunteer();
    }

    @Override
    public Optional<Volunteer> getVolunteer(Integer id) {
        return volunteerService.readVolunteerId(id);
    }

    @Override
    public Volunteer putVolunteer(Integer id, VolunteerDTO volunteerDTO) {
        return volunteerService.updateVolunteer(id, volunteerDTO);
    }

    @Override
    public void deleteVolunteer(Integer id) {
        volunteerService.deleteVolunteer(id);
    }

    @Override
    public List<Volunteer> listVolunteer(Integer confirmed) {
        return volunteerService.readVolunteerConfirmed(confirmed);
    }

    @Override
    public List<Volunteer> isVolunteer(Integer id) {
        Volunteer volunteer = volunteerService.readVolunteerId(id).orElse(null);
        User user = Objects.requireNonNull(volunteer).getUser();
        return volunteerService.readVolunteerUserAndAssistance(user, 1);
    }
}
