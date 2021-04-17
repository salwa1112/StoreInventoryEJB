package com.salwa.assignment2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


//Lombok is used to reduce boilerplate code for data objects,
//like it can generate getters and setters for those object automatically by using Lombok annotations
// The easiest way is to use the @Data annotation is a convenient shortcut annotation that bundles the features of
// @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together
@Data
//Lombok @NoArgsConstructor will generate a no arguments/default constructor and by default generated constructor will be public
@NoArgsConstructor
//Lombok @AllArgsConstructor will generate a constructor with 1 parameter for each field in the class
@AllArgsConstructor
//@Entity annotation identifies a class as an entity class
@Entity
//@Table annotation provides four attributes which allow to override the name of the table, its catalogue and its schema,
// and can enforce unique constraints on columns in the table
@Table(name = "inventories")

//query to find all product from Inventory entity
@NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")

//entity class as a table
public class Inventory implements Serializable {
    //Annotation @Id specifies the primary key of an entity
    @Id
    //@GeneratedValue JPA annotation annotation specifies that a value will be automatically generated for that field.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //The @Column annotation is used to specify the mapped column for a persistent property or a field.
    // So, if no Column annotation is specified then the default value will be applied.
    @Column(name = "inventory_id", columnDefinition = "smallint")
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "sport", length = 50)
    private String sport;

    @Column(name = "updated", columnDefinition = "TIMESTAMP")
    private LocalDateTime updated;

    @Column(name = "created", columnDefinition = "TIMESTAMP")
    private LocalDateTime created;

    @Column(name = "quantity", columnDefinition = "smallint")
    private int quantity;

    @Column(name = "pricePerUnit", columnDefinition = "NUMERIC(5,2)")
    private double pricePerUnit;

    //many to one relationship (1 store can have many product in the inventory)
    @ManyToOne
    //Specifies a column for joining an entity association/element collection
    @JoinColumn(name = "store_id_fk") //foreign key column (store id)
    private Store store; //bidirectional entity management
}
