/// change to Rest Controllers

package com.lindsaySenia.lucyscloset.v1.controllers;

import com.lindsaySenia.lucyscloset.v1.model.ItemDto;
import com.lindsaySenia.lucyscloset.v1.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor(onConstructor_={@Autowired})
public class ItemController {

    public final ItemService itemService;

    @GetMapping("/items")
    public String getAllItems(Model model) {
        clearModel(model);
        return "items";
    }
//@
    @PostMapping("/items")
    public String createNewItem(@ModelAttribute ItemDto newItem, Model model) {
        itemService.createItem(newItem);
        clearModel(model);
        return "items";
    }

    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable Long id, Model model) {
        itemService.deleteItemById(id);
        clearModel(model);
        return "items";
    }

    @PostMapping("/items/{id}")
    public String updateItem(@ModelAttribute ItemDto updatedItem, Model model) {
        itemService.updateItem(updatedItem);
        clearModel(model);
        return "items";
    }

    private void clearModel (Model model) {
        model.addAttribute("items", itemService.getAllItems());
        model.addAttribute("newItem", new ItemDto());
        model.addAttribute("updatedItem", new ItemDto());
    }

}

//when frontend asks for items give it the items (create html for each))