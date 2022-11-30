package com.plantavida.back.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dni;
    private String firstname;
    private String lastname;
    private String phone;
    private Date birth;
    private String gender;
    private String email;
    private String password;
    private Integer status;

    @OneToOne
    @JoinColumn(name = "roleId")
    private Role role;
}
