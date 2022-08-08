package com.minibar.proyectobarcito.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDTO {
    private String name;
    private String description;
    private Float pValue;

    public ProductDTO() {
    }
}
