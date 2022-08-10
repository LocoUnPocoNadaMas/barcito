/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minibar.proyectobarcito.repository;

import com.minibar.proyectobarcito.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Administrador
 */

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long>{

    public List<OrderModel> findByPaidFalseAndClientModel_ClientID(Long id);
    public List<OrderModel> findByPaidFalse();
}
