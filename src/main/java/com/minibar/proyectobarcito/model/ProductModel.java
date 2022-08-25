/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter @Setter @Entity
public class ProductModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long prodID;
    //@NotEmpty(message = "Required") // redundant, size it's better.
    @NotNull
    @Size(max = 40)
    private String name;
    @Size(max = 200)
    private String description;
    @NotNull @Positive @Column(scale = 2) // se pasa por las bolas el scale...o yo no lo se usar.
    private Double pValue;
    //@Column(columnDefinition = "boolean default true") // me crea un tipo de datos distinto al de hibernate...
    @NotNull
    private Boolean visible;

    public ProductModel() {
    }


}
