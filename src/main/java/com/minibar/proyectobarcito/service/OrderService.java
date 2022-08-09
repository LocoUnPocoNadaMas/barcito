package com.minibar.proyectobarcito.service;

import com.minibar.proyectobarcito.dto.OrderDTO;
import com.minibar.proyectobarcito.model.ItemOrderModel;
import com.minibar.proyectobarcito.model.OrderModel;
import com.minibar.proyectobarcito.model.ProductModel;
import com.minibar.proyectobarcito.repository.ItemOrderRepository;
import com.minibar.proyectobarcito.repository.OrderRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public ItemOrderRepository itemOrderRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public void addOrder(Long id) {
        System.out.println("uwu u");
        OrderModel oM = new OrderModel();
        oM.setOrderID(id);
        oM.setDateTime(LocalDate.now());
        oM.setOValue(1550.00f);
        oM.setPaid(true);
        orderPRepository.save(oM);

        ProductModel pM = new ProductModel();
        pM=productRepository.findById(id).orElse(null);
        ItemOrderModel itemOrderModel = new ItemOrderModel(oM, pM);
        itemOrderRepository.save(itemOrderModel);



        /*
        OrderModel oM = new OrderModel();
        ProductModel pM = new ProductModel();
        ItemOrderModel itemOrderModel;
        if(productRepository.findById(id).orElse(null) != null) {
            pM = productRepository.findById(id).orElse(null);
            itemOrderModel = new ItemOrderModel(oM, pM);
            itemOrderRepository.save(itemOrderModel);
        }*/
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
    }
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
