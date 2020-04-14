package com.todolistbackend.todolist.Controllers;

import com.todolistbackend.todolist.Entities.Item;
import com.todolistbackend.todolist.Services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemServices itemServices;

    @PostMapping(value = "/item/create")
    public String itemCreation(@RequestBody Item item) {
        itemServices.createItem(item);
        return "Success";
    }


    @PostMapping(value = "/item/itemRead")
    public List<Item> itemRead(@RequestBody String[] usernameAndStatus) {
        System.out.println("wait");
        List<Item> items = itemServices.readItem(usernameAndStatus);
        return items;
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
