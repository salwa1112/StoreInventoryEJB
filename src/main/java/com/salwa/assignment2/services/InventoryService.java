package com.salwa.assignment2.services;

import com.salwa.assignment2.entity.Inventory;

import java.util.List;

public interface InventoryService {

    void clearList();

    List<Inventory> getInventoryList();

    List<Inventory> getInventoryByStoreId(int id);

    void addToInventory(Inventory inventory);

    void removeInventory(Long id);
}
