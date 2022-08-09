package com.minibar.proyectobarcito.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter @Setter
public class ClientDTO {
    // Algún día Nelson algún día.
    // @Size(min = 15, max = 100)
    // private String codCli;
    @Positive
    private Long client_id;
    @Positive
    private Long prod_id;
}
