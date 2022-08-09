package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.OrderDTO;
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
 *
 * @author Administrador
 */

@Service
public class OrderService implements IOrderService {

    @Autowired
    public OrderRepository orderPRepository;

    @Autowired
    private ItemOrderRepository itemOrderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addNewOrder(Long id) {
        //itemOrderRepository.findByAddedToOrderAndClientID(false, id);
        List<ItemOrderModel> createdOrder = new ArrayList<>();
        Double value = 0.0;
        System.out.println("actualmente: "+value);
        OrderModel orderModel = new OrderModel();
        for (ItemOrderModel iOM : itemOrderRepository.findAll()) {
            //System.out.println(iOM.getProductModel().getName()+"1 ");
            if (!(iOM.getAddedToOrder())) {
                //System.out.println(iOM.getProductModel().getName()+"2 ");
                createdOrder.add(iOM);
                iOM.setAddedToOrder(true);
                //itemOrderRepository.save(iOM);
            }
        }
        itemOrderRepository.saveAll(createdOrder);

        for (ItemOrderModel iOM : createdOrder) {
            value += iOM.getProductModel().getPValue();
        }
        orderModel.setDateTime(LocalDate.now());
        orderModel.setOValue(value);
        orderModel.setPaid(false);
        orderPRepository.save(orderModel);
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

    @Override
    public List<OrderDTO> getOrders() {
        return  null;
    }
/*
        List<OrderDTO> orderDTOList = new ArrayList<>();
        OrderDTO orderDTO;
        for (OrderModel orderModel : orderPRepository.findAll()) {
            if (orderModel.getPaid() != false) {
                orderDTO = new OrderDTO();
                orderDTO.setId(orderModel.getOrderID());
                orderDTO.setDateTime(orderModel.getDateTime());
                orderDTO.setOValue(orderModel.getOValue());
                orderDTO.setPaid(orderModel.getPaid());
                orderDTOList.add(orderDTO);
            }
        }
        return orderDTOList;
    }*/
    /*
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
    }*/
    
}
