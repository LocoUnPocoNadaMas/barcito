package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.OrderDTO;
import com.minibar.proyectobarcito.model.ItemOrderModel;
import com.minibar.proyectobarcito.model.OrderModel;
import com.minibar.proyectobarcito.repository.ItemOrderRepository;
import com.minibar.proyectobarcito.repository.OrderRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean createNextOrder() {

        Long ClientIdOfFirstItem = 0L;
        ItemOrderModel firstItem = itemOrderRepository.findFirstByAddedToOrderFalse();
        OrderModel newOrder = new OrderModel();

        Double value = 0.0;
        List <ItemOrderModel> itemOrderModelList = new ArrayList<>();
        // get first item waiting be added
        if (firstItem != null) {
            // getting id
            ClientIdOfFirstItem = firstItem.getClientModel().getClientID();
            // create a list of items, using the clientid
            // of the first item, where addedtoorder=false
            itemOrderModelList = itemOrderRepository.findByClientModel_ClientIDAndAddedToOrderFalse(ClientIdOfFirstItem);

            if(!(itemOrderModelList.isEmpty())) {

                for (ItemOrderModel itemOrderModel : itemOrderModelList) {
                    value += itemOrderModel.getProductModel().getPValue();
                    itemOrderModel.setAddedToOrder(true);
                }
                itemOrderRepository.saveAll(itemOrderModelList);

                if (value > 0.0) {

                    newOrder.setDateTime(LocalDateTime.now());
                    newOrder.setOValue(value);
                    newOrder.setPaid(false);
                    newOrder.setClientModel(firstItem.getClientModel());
                    orderRepository.save(newOrder);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<OrderModel> getUnattendedOrders() {
        return null;
    }

    @Override
    public List<OrderModel> getUnpaidOrders() {

        return orderRepository.findByPaidFalse();
    }

    @Override
    public OrderModel findOrder(Long id) {
        //return orderRepository.findById(id).orElse(null);
        return null;
    }

    @Override
    public void updateOrder(Long id, Float oValue) {

    }

    @Override
    public void deleteOrder(Long id) {

    }
}
