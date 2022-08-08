/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.controller;

import com.minibar.proyectobarcito.dto.OrderDTO;
import com.minibar.proyectobarcito.dto.ProductDTO;
import com.minibar.proyectobarcito.model.OrderModel;
import com.minibar.proyectobarcito.service.IOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Administrador
 */

@RestController
@RequestMapping("/orden")
public class OrderController {
    
    @Autowired
    private IOrderService orderService;
    
    @GetMapping("/todas")
    public List<OrderDTO> showOrders(){
        return orderService.getOrders();
    }
    
    @PostMapping("/agregar/{id}")
    public void addOrder(@PathVariable Long id) {

        System.out.println("uwu");

        orderService.addOrder(id);
    }
    
    @GetMapping("/buscar/{id}")
    public OrderModel getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
    
    @PutMapping("/editar/{id}")
    public void updateProduct(@PathVariable Long id,
            @RequestParam ("ovalue") Float nValue) {
        
        orderService.updateOrder(id, nValue);
    }
    
    @GetMapping("/borrar/{id}")
    public void deleteProduct(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
    
}
