package com.minibar.proyectobarcito.dto;

import com.minibar.proyectobarcito.model.ItemOrderModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class OrderDTO implements Serializable {

    private Long id;
    private LocalDate dateTime;
    private Float oValue;
    private Boolean paid;
    private List<ItemOrderModel> itemOrderModels;

    public OrderDTO() {
    }
}
