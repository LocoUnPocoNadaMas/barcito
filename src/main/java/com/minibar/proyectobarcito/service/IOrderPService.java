/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.model.OrderModel;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IOrderPService {
    
    public void addOrderP(OrderModel product);
    
    public OrderModel getOrderP(Long id);
    
    public void updateOrderP(Long id, Float oValue);
    
    public void deleteOrderP(Long id);

    public List<OrderModel> getOrderPs();
}
