package com.plantavida.back.domain.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "publication")
@Data
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String cover;
    private String body;
    private String author;
    private String pDate;
}
