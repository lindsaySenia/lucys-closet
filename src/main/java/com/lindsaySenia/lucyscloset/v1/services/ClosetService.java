package com.lindsaySenia.lucyscloset.v1.services;

import com.lindsaySenia.lucyscloset.v1.model.ClosetDto;

import java.util.List;
import java.util.Optional;

public interface ClosetService {

    List<ClosetDto> getAllClosets();

    ClosetDto createCloset(ClosetDto closetDto);

    Optional<ClosetDto> getClosetById(Long id);
}
