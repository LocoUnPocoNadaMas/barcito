package com.minibar.proyectobarcito.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter @Getter @Entity
//@Embeddable
public class ItemOrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemID;
    @ManyToOne
    @JoinColumn(
            name = "orderID",
            nullable = false, updatable = false // -nullable
    )
    @NotNull
    private OrderModel orderModel;
    @ManyToOne
    @JoinColumn(
            name = "prodID",
            nullable = false, updatable = false // -nullable
    )
    @NotNull
    private ProductModel productModel;

    @OneToOne(mappedBy = "itemOrderModel", cascade = CascadeType.ALL)
    //@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    //*******************************************************************
    //      The PrimaryKeyJoinColumn annotation does say that the       *
    // primary key of the entity is used as the foreign key value to    *
    // the associated entity.                                           *
    //******************************************************************/
    private DetailItemOrderModel detailItemOrderModel;

    public ItemOrderModel() {
    }

    public ItemOrderModel(OrderModel orderModel, ProductModel productModel) {
        this.orderModel = orderModel;
        this.productModel = productModel;
    }
}
