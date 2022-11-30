package com.plantavida.back.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "volunteer")
@Data
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private Integer confirmed;
    private Integer assistance;
}
