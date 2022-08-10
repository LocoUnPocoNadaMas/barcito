package com.minibar.proyectobarcito.repository;

import com.minibar.proyectobarcito.model.ClientModel;
import com.minibar.proyectobarcito.model.ItemOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrderModel, Long> {

    public List<ItemOrderModel> findByAddedToOrderFalse();

    public ItemOrderModel findFirstByAddedToOrderFalse(); //using

    public List<ItemOrderModel> findByClientModel_ClientIDAndAddedToOrderFalse(Long id); //using

}
