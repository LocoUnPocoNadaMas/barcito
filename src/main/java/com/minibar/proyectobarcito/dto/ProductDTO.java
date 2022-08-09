package com.minibar.proyectobarcito.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter @Setter
public class ProductDTO {
    @Size(min = 5, max = 40)
    private String name;
    //@Size(max = 200)
    private String description;
    @Positive
    private Double pValue;

    public ProductDTO() {
    }
}
