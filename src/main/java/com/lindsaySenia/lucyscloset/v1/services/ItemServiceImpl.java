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
        return new ItemDto(itemRepository.save(item));
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
        return;
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
            return Optional.of(new ItemDto(itemRepository.save(item)));
        }
        return Optional.empty();
    }
}
//optional - something might be null/not found
//may or may have the id that is passed in ... if not returns empty optional