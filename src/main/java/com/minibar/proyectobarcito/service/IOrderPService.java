/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.model.OrderP;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IOrderPService {
    
    public void addOrderP(OrderP product);
    
    public OrderP getOrderP(Long id);
    
    public void updateOrderP(Long id, Float oValue);
    
    public void deleteOrderP(Long id);

    public List<OrderP> getOrderPs();
}
