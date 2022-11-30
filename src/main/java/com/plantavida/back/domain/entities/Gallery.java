package com.plantavida.back.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "gallery")
@Data
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;
    private String description;
}
