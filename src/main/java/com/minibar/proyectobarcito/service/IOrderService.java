/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.OrderDTO;
import com.minibar.proyectobarcito.model.OrderModel;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IOrderService {

    /**
     * Método para que el cliente agregue la orden
     * En un futuro será Modularizado , Modularizar
     * @param id
     */
    public void addOrder(Long id);

    /**
     * Busca informacíon sobre una orden en particular
     * @param id
     * @return
     */
    public OrderModel getOrder(Long id);

    /**
     * Este método actualiza las ordenes, SIN RESOLVER AÚN
     * @param id
     * @param oValue
     */
    public void updateOrder(Long id, Float oValue);

    /**
     * Este método oculta las ordenes que no se van a realizar
     * @param id
     */
    public void deleteOrder(Long id);

    /**
     * Este método devuelve las ordenes que no se atendieron
     * @return list of next orders
     */
    public List<OrderDTO> getOrders();
}
