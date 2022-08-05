/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minibar.proyectobarcito.controller;

import com.minibar.proyectobarcito.model.OrderP;
import com.minibar.proyectobarcito.service.IOrderPService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */

@RestController
@RequestMapping("/orden")
public class OrderController {
    
    @Autowired
    private IOrderPService orderPService;
    
    @GetMapping("/todas")
    public List<OrderP> showOrderPs(){
        return orderPService.getOrderPs();
    }
    
    @GetMapping("/agregar")
    public void addProduct(@RequestBody OrderP orderP) {
        orderPService.addOrderP(orderP);
    }
    
    @GetMapping("/buscar/{id}")
    public OrderP getProduct(@PathVariable Long id) {
        return orderPService.getOrderP(id);
    }
    
    @PutMapping("/editar/{id}")
    public void updateProduct(@PathVariable Long id,
            @RequestParam ("ovalue") Float nValue) {
        
        orderPService.updateOrderP(id, nValue);
    }
    
    @GetMapping("/borrar/{id}")
    public void deleteProduct(@PathVariable Long id) {
        orderPService.deleteOrderP(id);
    }
    
}
