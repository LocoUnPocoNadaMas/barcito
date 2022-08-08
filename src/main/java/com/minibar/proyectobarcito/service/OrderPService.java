/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.OrderDTO;
import com.minibar.proyectobarcito.model.ItemOrderModel;
import com.minibar.proyectobarcito.model.OrderModel;
import com.minibar.proyectobarcito.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */

@Service
public class OrderPService implements IOrderPService{

    @Autowired
    public OrderRepository orderPRepository;
    
    @Override
    public void addOrderP(OrderModel orderModel) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.getItemOrderModels();
        ItemOrderModel itemOrderModel = new ItemOrderModel();
        //itemOrderModel.g
        orderPRepository.save(orderModel);
    }

    @Override
    public OrderModel getOrderP(Long id) {
        return orderPRepository.findById(id).orElse(null);
    }

    @Override
    public void updateOrderP(Long id, Float oValue) {
        OrderModel orderModel = getOrderP(id);
        orderModel.setOValue(oValue);
        orderPRepository.save(orderModel);
    }

    @Override
    public void deleteOrderP(Long id) {
        orderPRepository.deleteById(id);
    }

    @Override
    public List<OrderModel> getOrderPs() {
        return orderPRepository.findAll();
    }
    
}
