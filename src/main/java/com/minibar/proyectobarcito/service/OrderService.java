package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.OrderDTO;
import com.minibar.proyectobarcito.model.ClientModel;
import com.minibar.proyectobarcito.model.ItemOrderModel;
import com.minibar.proyectobarcito.model.OrderModel;
import com.minibar.proyectobarcito.model.ProductModel;
import com.minibar.proyectobarcito.repository.ItemOrderRepository;
import com.minibar.proyectobarcito.repository.OrderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.minibar.proyectobarcito.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrador
 */

@Service
public class OrderService implements IOrderService {

    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    public ItemOrderRepository itemOrderRepository;
    @Autowired
    public ProductRepository productRepository;

    @Override
    public boolean createNextOrder() {

        Long ClientIdOfFirstItem = 0L;
        ItemOrderModel firstItem = new ItemOrderModel();
        OrderModel newOrder = new OrderModel();
        Double value = 0.0;
        // get first item waiting be added
        if (itemOrderRepository.findFirstByAddedToOrderFalse() != null) {
            firstItem = itemOrderRepository.findFirstByAddedToOrderFalse();
            ClientIdOfFirstItem = firstItem.getClientModel().getClientID();
        }

        // create a list of items, using the clientid
        // of the first item, where addedtoorder=false
        for (ItemOrderModel itemOrderModel : itemOrderRepository.findByClientModel_ClientIDAndAddedToOrderFalse(ClientIdOfFirstItem)
        ) {
            value += itemOrderModel.getProductModel().getPValue();
            itemOrderModel.setAddedToOrder(true);
        }
        itemOrderRepository.saveAll(itemOrderRepository.findByClientModel_ClientIDAndAddedToOrderFalse(ClientIdOfFirstItem));

        if (value > 0.0) {

            newOrder.setDateTime(LocalDate.now());
            newOrder.setOValue(value);
            newOrder.setPaid(false);
            orderRepository.save(newOrder);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderDTO> getUnattendedOrders() {
        return null;
    }

    @Override
    public List<ItemOrderModel> getUnpaidOrders() {
        return null;
    }

    @Override
    public OrderModel getOrder(Long id) {
        return null;
    }

    @Override
    public void updateOrder(Long id, Float oValue) {

    }

    @Override
    public void deleteOrder(Long id) {

    }
}
