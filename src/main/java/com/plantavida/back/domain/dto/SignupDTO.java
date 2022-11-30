package com.plantavida.back.domain.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class SignupDTO {
    private String dni;
    private String firstname;
    private String lastname;
    private String phone;
    private Date birth;
    private String gender;
    private String email;
    private String password;
}
