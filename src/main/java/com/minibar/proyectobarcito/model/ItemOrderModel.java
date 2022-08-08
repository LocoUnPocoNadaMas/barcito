package com.minibar.proyectobarcito.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter @Getter @Entity
public class ItemOrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long itemID;

}
