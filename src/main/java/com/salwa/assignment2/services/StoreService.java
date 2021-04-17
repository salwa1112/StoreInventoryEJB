package com.salwa.assignment2.services;

import com.salwa.assignment2.entity.Store;

import java.util.List;

public interface StoreService {
    void clearList();

    List<Store> getStoreList();

    void addToStore(Store store);

    void removeStore(Long id);

    Store findStoreById(int id);
}
