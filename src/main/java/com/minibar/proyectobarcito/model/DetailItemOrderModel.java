package com.minibar.proyectobarcito.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter @Entity
//@Embeddable // No es una entidad por sí misma, depende de otra.
public class DetailItemOrderModel {

    @Id
    private Long detailID;
    @NotNull
    @Size(max = 200)
    private String detail;

    @OneToOne
    //@OneToOne(mappedBy = "detailItemOrderModel")
    @MapsId
    //*******************************************************************
    //      The MapsId annotation ask Hibernate to copy the identifier  *
    //  from another associated entity. In the Hibernate jargon, it is  *
    //  known as a foreign generator but the JPA mapping reads better   *
    //  and is encouraged.                                              *
    //******************************************************************/
    // https://stackoverflow.com/questions/6833370/jpa-onetoone-with-shared-id-can-i-do-this-better
    @JoinColumn(name = "itemID")
    //@JoinColumn(name = "detailid")
    private ItemOrderModel itemOrderModel;


}
