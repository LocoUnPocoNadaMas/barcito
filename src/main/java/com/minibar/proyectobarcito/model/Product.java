/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrador
 */

@Getter @Setter @Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    Long pId;
    String name;
    String description;
    Float pValue;
    
    @ManyToMany(mappedBy = "products")
    private Set<OrderP> orders = new HashSet<>();
}
