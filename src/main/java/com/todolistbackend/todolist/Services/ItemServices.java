package com.todolistbackend.todolist.Services;

import com.todolistbackend.todolist.Entities.Item;
import com.todolistbackend.todolist.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServices {

    @Autowired
    ItemRepository itemRepository;

    //Basic CRUD Operations
    public void createItem(Item item) {itemRepository.save(item);}

    public List<Item> readItem (String[] usernameAndStatus) {return itemRepository.findItemsByUsernameAndStatus(usernameAndStatus[0], usernameAndStatus[1]);}

    public void updateItem (Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(Item item) {
        itemRepository.deleteItemsWhereUsernameAndStatus(item.getUsername(), item.getStatus());}

}
