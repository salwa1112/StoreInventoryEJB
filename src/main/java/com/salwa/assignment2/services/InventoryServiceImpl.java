package com.salwa.assignment2.services;


import com.salwa.assignment2.entity.Inventory;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

//@Stateless annotation to signify it a stateless bean, EJB Container automatically creates
// the relevant configurations or interfaces required by reading this annotation during deployment process.
@Stateless
//@Remote annotation is applied to the session bean class or remote business interface
// to designate a remote business interface of the bean
@Remote(InventoryService.class)
public class InventoryServiceImpl implements InventoryService {

    //Persistence Context is an environment where entity instances(which are capable of holding
    // data and thereby having the ability to be persisted in a database) are managed by Entity Manager.
    // It syncs the entity with the database, all objects having @Entity annotation are capable of being persisted
    @PersistenceContext
    private EntityManager em;

    //clear list
    @Override
    public void clearList() {
        Query clearInventory = em.createNamedQuery("Inventory.findAll");
        clearInventory.executeUpdate();
    }

    @Override
    public List<Inventory> getInventoryList() {
        Query query = em.createNamedQuery("Inventory.findAll", Inventory.class);
        List<Inventory> inventories = query.getResultList();
        return inventories;
    }

    @Override
    public List<Inventory> getInventoryByStoreId(int id) {
        Query query = em.createNamedQuery("Inventory.findAll", Inventory.class);
        List<Inventory> inventories = query.getResultList();
        return inventories.stream().filter(c -> c.getStore().getId() == id)
                .collect(Collectors.toList());
    }


    @Override
    public void addToInventory(Inventory inventory) {
        em.persist(inventory);
    }

    @Override
    public void removeInventory(Long id) {
        Inventory inventory = em.find(Inventory.class, id);
        if (inventory != null) {
            em.remove(inventory);
        }
    }


}
