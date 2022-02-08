package com.lindsaySenia.lucyscloset.v1.controllers;


import com.lindsaySenia.lucyscloset.v1.entities.Closet;
import com.lindsaySenia.lucyscloset.v1.model.ClosetDto;
import com.lindsaySenia.lucyscloset.v1.model.ItemDto;
import com.lindsaySenia.lucyscloset.v1.services.ClosetItemService;
import com.lindsaySenia.lucyscloset.v1.services.ClosetService;
import com.lindsaySenia.lucyscloset.v1.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class ClosetController {
    private final ClosetService closetService;
    private final ItemService itemService;
    private final ClosetItemService closetItemService;

    @GetMapping("/closets")
    public List<ClosetDto> getClosets() {
        return closetService.getAllClosets();
    }

    @PostMapping("/closets")
    public ClosetDto createCloset(@RequestBody ClosetDto closetDto) {
        return closetService.createCloset(closetDto);
    }

    @PostMapping("/closets/{id}/items")
    public String addItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        ItemDto itemToSave;
        if (itemDto.getId() != null) {
            Optional<ItemDto> existingItem = itemService.findItemById(itemDto.getId());
            if(existingItem.isEmpty()){
                return "Item with Id: " + itemDto.getId() + " not found";
            }
            itemToSave = existingItem.get();
        } else {
            itemToSave = itemService.createItem(itemDto);
        }
        closetItemService.addItemToCloset(id, itemToSave);
        return "Successfully added item";
    }
}
