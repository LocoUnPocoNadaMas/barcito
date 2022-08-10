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
    private Boolean addedToOrder;
    @ManyToOne
    @JoinColumn(
            name = "prodID",
            nullable = false, updatable = false // -nullable
    )
    @NotNull
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(
            name = "clientID",
            nullable = false, updatable = false // -nullable
    )
    @NotNull
    private ClientModel clientModel;

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

    public ItemOrderModel(ProductModel productModel, ClientModel clientModel) {
        this.productModel = productModel;
        this.clientModel = clientModel;
    }
}
