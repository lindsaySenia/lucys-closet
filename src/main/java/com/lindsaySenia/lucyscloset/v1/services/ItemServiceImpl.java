package com.lindsaySenia.lucyscloset.v1.services;


import com.lindsaySenia.lucyscloset.v1.entities.Item;
import com.lindsaySenia.lucyscloset.v1.model.ItemDto;
import com.lindsaySenia.lucyscloset.v1.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_={@Autowired})
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public List<ItemDto> getAllItems() {
        return itemRepository.findAll().stream().map(ItemDto::new).collect(Collectors.toList());
    }
// find all items, change all into itemDtos , collect to list and return to calling function


    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setBrand(itemDto.getBrand());
        item.setType(itemDto.getType());
        item.setSize(itemDto.getSize());
        item.setColor(itemDto.getColor());
        item.setImageUrl(itemDto.getImageUrl());
        itemRepository.save(item);
        return new ItemDto(item);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Optional<ItemDto> updateItem(ItemDto itemDto) {
        Optional<Item> itemOptional = itemRepository.findById(itemDto.getId());
        if(itemOptional.isPresent()){
            Item item = itemOptional.get();
            item.setName(itemDto.getName());
            item.setBrand(itemDto.getBrand());
            item.setType(itemDto.getType());
            item.setSize(itemDto.getSize());
            item.setColor(itemDto.getColor());
            item.setImageUrl(itemDto.getImageUrl());
            itemRepository.save(item);
            return Optional.of(new ItemDto(item));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ItemDto> findItemById(Long id) {
        return itemRepository.findById(id).map(ItemDto::new);
    }

//    @Override
//    public Optional<ItemDto> findItemByName(String itemName) {
//        return itemRepository.findAll().contains(itemName).map(ItemDto::new);
//    }
}
//optional - something might be null/not found
//may or may have the id that is passed in ... if not returns empty optional