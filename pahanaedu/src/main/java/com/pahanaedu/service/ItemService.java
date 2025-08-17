package com.pahanaedu.service;

import com.pahanaedu.model.Item;
import com.pahanaedu.repository.ItemRepository;

import java.util.List;

public class ItemService {

    private ItemRepository itemRepository;

    public ItemService() {
        this.itemRepository = new ItemRepository();
    }

    public void addItem(Item item) {
        itemRepository.addItem(item);
    }

    public void updateItem(Item item) {
        itemRepository.updateItem(item);
    }

    public void deleteItem(int id) {
        itemRepository.deleteItem(id);
    }

    public Item getItemById(int id) {
        return itemRepository.getItemById(id);
    }

    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }
}
