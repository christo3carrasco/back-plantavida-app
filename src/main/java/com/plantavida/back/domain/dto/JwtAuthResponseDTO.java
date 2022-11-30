package com.plantavida.back.domain.dto;

import lombok.Data;

@Data
public class JwtAuthResponseDTO {
    private String tokenAccess;
    private String tokenType = "Bearer";

    public JwtAuthResponseDTO(String tokenAccess) {
        super();
        this.tokenAccess = tokenAccess;
    }
}
