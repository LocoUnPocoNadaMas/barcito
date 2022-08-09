package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.ClientDTO;
import com.minibar.proyectobarcito.model.ClientModel;
import com.minibar.proyectobarcito.model.ItemOrderModel;
import com.minibar.proyectobarcito.model.ProductModel;
import com.minibar.proyectobarcito.repository.ClienteRepository;
import com.minibar.proyectobarcito.repository.ItemOrderRepository;
import com.minibar.proyectobarcito.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService{

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ItemOrderRepository itemOrderRepository;

    @Override
    public boolean addNewItem(ClientDTO clientDTO) {
        ClientModel cM = new ClientModel();
        cM = clienteRepository.findById(clientDTO.getClient_id()).orElse(null);
        ProductModel pM = new ProductModel();
        pM = productRepository.findById(clientDTO.getProd_id()).orElse(null);
        if (pM != null && cM != null) {
            ItemOrderModel iOM = new ItemOrderModel(pM, cM);
            itemOrderRepository.save(iOM);
            return true;
        }
        return false;
    }
}
