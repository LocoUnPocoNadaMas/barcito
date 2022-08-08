/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    //@Temporal(value = TemporalType.DATE)
    LocalDate dateTime;
    @Positive
    Float oValue;
    @Value("false")
    Boolean paid;

    @OneToMany
    @JoinColumn(
            name = "orderID",
            nullable = false
    )

    private Set<ItemOrderModel> itemOrderModels = new HashSet<>();
}
