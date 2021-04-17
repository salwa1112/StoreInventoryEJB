package com.salwa.assignment2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stores")

//query to find all store
@NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")

//entity class as a table
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", columnDefinition = "smallint")
    private int id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "location", length = 150)
    private String location;

    //one to many relationship (one store can have many product in the inventory)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Inventory> inventories = new ArrayList<>();
}
