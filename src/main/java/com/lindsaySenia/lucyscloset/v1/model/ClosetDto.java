package com.lindsaySenia.lucyscloset.v1.model;


import com.lindsaySenia.lucyscloset.v1.entities.Closet;
import com.lindsaySenia.lucyscloset.v1.entities.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ClosetDto {

    private Long id;
    private String name;
    private String description;

    private Set<ItemDto> items;

    public ClosetDto(Closet closet) {
        this.id = closet.getId();
        this.name = closet.getName();
        this.description = closet.getDescription();
        this.items = new HashSet<>();

    }
}
