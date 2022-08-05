/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrador
 */
    @Setter @Getter @Entity
public class OrderP {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long oId;
    LocalDate dateTime;
    Float oValue;
    
    /*
    @ManyToMany(targetEntity = OrderP.class)
    private Set Order_has_Product;*/
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        //name = "Order_has_Product", 
        joinColumns = { @JoinColumn(name = "oId") }, 
        inverseJoinColumns = { @JoinColumn(name = "pId") }
    )
    Set<Product> products = new HashSet<>();
    
}
