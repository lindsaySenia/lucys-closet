package com.lindsaySenia.lucyscloset.v1.services;

import com.lindsaySenia.lucyscloset.v1.entities.Closet;
import com.lindsaySenia.lucyscloset.v1.model.ClosetDto;
import com.lindsaySenia.lucyscloset.v1.model.ItemDto;
import com.lindsaySenia.lucyscloset.v1.repositories.ClosetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class ClosetServiceImpl implements ClosetService{

    private final ClosetRepository closetRepository;

    @Override
    public List<ClosetDto> getAllClosets() {
        return closetRepository.findAll().stream().map(closet -> {
            ClosetDto closetDto = new ClosetDto(closet);
            closetDto.setItems(closet.getItems().stream().map(ItemDto::new).collect(Collectors.toSet()));
            return closetDto;
        }).collect(Collectors.toList());
    }

    @Override
    public ClosetDto createCloset(ClosetDto closetDto) {
        Closet closet = new Closet();
        closet.setName(closetDto.getName());
        closet.setDescription(closetDto.getDescription());
        closet.setItems(new HashSet<>());
        return new ClosetDto(closetRepository.save(closet));
    }

    @Override
    public Optional<ClosetDto> getClosetById(Long id) {
        return closetRepository.findById(id).map(ClosetDto::new);
    }


}
