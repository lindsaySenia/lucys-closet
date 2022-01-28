package com.lindsaySenia.lucyscloset.v1.services;

import com.lindsaySenia.lucyscloset.v1.model.ItemDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemDto> getAllItems();

    ItemDto createItem(ItemDto item);

    void deleteItemById(Long id);

    Optional<ItemDto> updateItem(ItemDto item);

}


//create service to handle many to many relationship
//create native query entity manager @PersistanceContext  (maybe return as a list)