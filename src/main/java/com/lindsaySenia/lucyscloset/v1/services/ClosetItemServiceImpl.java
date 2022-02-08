package com.lindsaySenia.lucyscloset.v1.services;

import com.lindsaySenia.lucyscloset.v1.entities.Closet;
import com.lindsaySenia.lucyscloset.v1.entities.Item;
import com.lindsaySenia.lucyscloset.v1.model.ItemDto;
import com.lindsaySenia.lucyscloset.v1.repositories.ClosetRepository;
import com.lindsaySenia.lucyscloset.v1.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class ClosetItemServiceImpl implements ClosetItemService{

    private final ClosetRepository closetRepository;
    private final ItemRepository itemRepository;

    @Override
    public boolean addItemToCloset(Long id, ItemDto itemToAdd) {
        Optional<Closet> closetOptional = closetRepository.findById(id);
        Optional<Item> itemOptional = itemRepository.findById(itemToAdd.getId());
        if(closetOptional.isPresent() && itemOptional.isPresent()){
            Closet closet = closetOptional.get();
            closet.getItems().add(itemOptional.get());
            closetRepository.save(closet);
            return true;
        }
        return false;
    }
}
