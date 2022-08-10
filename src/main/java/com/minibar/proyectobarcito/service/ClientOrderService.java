package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.ClientDTO;
import com.minibar.proyectobarcito.dto.ClientOrderDTO;
import com.minibar.proyectobarcito.model.ClientModel;
import com.minibar.proyectobarcito.model.ItemOrderModel;
import com.minibar.proyectobarcito.model.OrderModel;
import com.minibar.proyectobarcito.model.ProductModel;
import com.minibar.proyectobarcito.repository.ClientRepository;
import com.minibar.proyectobarcito.repository.ItemOrderRepository;
import com.minibar.proyectobarcito.repository.OrderRepository;
import com.minibar.proyectobarcito.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientOrderService implements IClientOrderService {

    @Autowired
    public ClientRepository clientRepository;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public ItemOrderRepository itemOrderRepository;

    @Autowired
    public OrderRepository orderRepository;

    @Override
    public boolean addNewItem(ClientDTO clientDTO) {
        ClientModel cM = new ClientModel();
        //cM = clientOrderRepository.findById(clientDTO.getClient_id()).orElse(null);
        ProductModel pM = new ProductModel();
        pM = productRepository.findById(clientDTO.getProd_id()).orElse(null);
        if (pM != null && cM != null) {
            ItemOrderModel iOM = new ItemOrderModel(pM, cM);
            iOM.setAddedToOrder(false);
            itemOrderRepository.save(iOM);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderModel> getOrderItems(Long id) {
        return orderRepository.findByPaidFalseAndClientModel_ClientID(id);
        //return null;
    }


}
