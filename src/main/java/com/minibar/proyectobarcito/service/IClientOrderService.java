package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.ClientDTO;
import com.minibar.proyectobarcito.model.OrderModel;

import java.util.List;

public interface IClientOrderService {

    public boolean addNewItem(ClientDTO clientDTO);

    public List<OrderModel> getOrderItems(Long id);
}
