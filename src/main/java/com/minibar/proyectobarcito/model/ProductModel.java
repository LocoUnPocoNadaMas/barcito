/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author Administrador
 */

@Getter @Setter @Entity
public class ProductModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    @NotEmpty(message = "Required")
    @Size(max = 40)
    String name;
    @Size(max = 200)
    String description;
    @Positive(message = "")
    Float pValue;
    @Value("true")
    Boolean visible;
    
    @OneToMany
    @JoinColumn(
            name = "prodID",
            nullable = false
    )

    private Set<ItemOrderModel> itemOrderModels = new HashSet<>();
}
