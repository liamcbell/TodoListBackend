package com.todolistbackend.todolist.Controllers;

import com.todolistbackend.todolist.Entities.Item;
import com.todolistbackend.todolist.Services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemServices itemServices;

    @PostMapping(value = "/item/itemCreation")
    public String itemCreation(@RequestBody Item item) {
        itemServices.createItem(item);
        return "Success";
    }
    @PostMapping(value = "/item/itemRead")
    public List<Item> itemRead(@RequestBody String username) {
        return itemServices.readItem(username);
    }
    @PostMapping(value = "/item/itemUpdate")
    public String itemUpdate(@RequestBody Item item) {
        itemServices.updateItem(item);
        return "Success";
    }

    @PostMapping(value = "/item/itemDeletion")
    public String itemDeletion(@RequestBody Item item) {
        itemServices.deleteItem(item);
        return "Success";
    }
}
