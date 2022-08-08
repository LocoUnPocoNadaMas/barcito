package com.minibar.proyectobarcito.repository;

import com.minibar.proyectobarcito.model.ItemOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrderModel, Long> {
}
