/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter @Entity
public class OrderModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;
    //private LocalDate addedOn = LocalDate.now();
    //@Column(updatable = false) // secure
    @NotNull
    private LocalDateTime dateTime;
    @NotNull
    @Positive
    private Double oValue;
    // @Value("false") esta porquería no funciona, se setea desde el constructor?
    private Boolean paid;

    @ManyToOne
    @JoinColumn(
            name = "clientID",
            nullable = false, updatable = false // -nullable
    )
    @NotNull
    private ClientModel clientModel;

    public OrderModel() {
    }

    public OrderModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }
}
