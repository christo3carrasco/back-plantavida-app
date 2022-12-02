package com.plantavida.back.domain.dto;

import com.plantavida.back.domain.entities.Event;
import com.plantavida.back.domain.entities.User;
import lombok.Data;

@Data
public class VolunteerDTO {
    private Integer id;
    private Event event;
    private User user;
    private Integer confirmed;
    private Integer assistance;
}
