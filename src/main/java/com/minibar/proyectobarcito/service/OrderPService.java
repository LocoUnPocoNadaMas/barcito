/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.model.OrderP;
import com.minibar.proyectobarcito.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Administrador
 */

@Service
public class OrderPService implements IOrderPService{

    @Autowired
    public OrderRepository orderPRepository;
    
    @Override
    public void addOrderP(OrderP orderP) {
        orderPRepository.save(orderP);
    }

    @Override
    public OrderP getOrderP(Long id) {
        return orderPRepository.findById(id).orElse(null);
    }

    @Override
    public void updateOrderP(Long id, Float oValue) {
        OrderP orderP = getOrderP(id);
        orderP.setOValue(oValue);
        orderPRepository.save(orderP);
    }

    @Override
    public void deleteOrderP(Long id) {
        orderPRepository.deleteById(id);
    }

    @Override
    public List<OrderP> getOrderPs() {
        return orderPRepository.findAll();
    }
    
}
