package com.lindsaySenia.lucyscloset.v1.services;

import com.lindsaySenia.lucyscloset.v1.model.ItemDto;

public interface ClosetItemService {
        boolean addItemToCloset(Long id, ItemDto itemToAdd);
}
