/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;

/**
 *
 * @author Administrador
 */
@Setter @Getter @Entity
public class OrderModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;
    //private LocalDate addedOn = LocalDate.now();
    //@Column(updatable = false) // secure
    @NotNull
    private LocalDate dateTime;
    @NotNull
    @Positive
    private Float oValue;
    // @Value("false") esta porquería no funciona, se setea desde el constructor?
    private Boolean paid;

    public OrderModel() {
    }
}
