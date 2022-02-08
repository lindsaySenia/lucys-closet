package com.lindsaySenia.lucyscloset.v1.controllers;

import com.lindsaySenia.lucyscloset.v1.model.ItemDto;
import com.lindsaySenia.lucyscloset.v1.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(onConstructor_={@Autowired})
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Optional<ItemDto> getItemById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    @PutMapping("/items/{id}")
    public Optional<ItemDto> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return itemService.updateItem(itemDto);
    }

    @PostMapping("/items")
    public ItemDto createItem(@RequestBody ItemDto itemDto) {
        return itemService.createItem(itemDto);
    }

    @DeleteMapping("/items/{id}")
    public Boolean deleteItem(@PathVariable Long id){
        itemService.deleteItemById(id);
        return Boolean.TRUE;
    }
}
