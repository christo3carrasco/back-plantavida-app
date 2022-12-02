package com.plantavida.back.domain.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class EventDTO {
    private Integer id;
    private String name;
    private String place;
    private Time timeEv;
    private Date dateEv;
    private Integer status;
}
