package com.salwa.assignment2.services;


import com.salwa.assignment2.entity.Store;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
@Remote(StoreService.class)
public class StoreServiceImpl implements StoreService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void clearList() {
        Query clearStore = em.createNamedQuery("Store.findAll");
        clearStore.executeUpdate();
    }

    @Override
    public List<Store> getStoreList() {
        Query query = em.createNamedQuery("Store.findAll", Store.class);
        List<Store> stores = query.getResultList();
        return stores;
    }


    @Override
    public void addToStore(Store store) {
        em.persist(store);
    }

    @Override
    public void removeStore(Long id) {
        Store storeToDelete = em.find(Store.class, id);
        if (storeToDelete != null) {
            em.remove(storeToDelete);
            //print out the store id in the server log
            System.out.println("Store-delete " + id);
        }
    }

    @Override
    public Store findStoreById(int id) {
        Store store = em.find(Store.class, id);
        return store;
    }

}
