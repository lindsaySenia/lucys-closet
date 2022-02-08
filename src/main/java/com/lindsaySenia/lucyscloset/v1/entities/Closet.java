package com.lindsaySenia.lucyscloset.v1.entities;

import com.lindsaySenia.lucyscloset.v1.model.ClosetDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Closet {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "closet_item",
        joinColumns = @JoinColumn(name = "closet_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @EqualsAndHashCode.Exclude
    private Set<Item> items;
//     = new HashSet<>();

//    public Closet(ClosetDto closetDto) {
//        this.name = closetDto.getName();
//        this.description = closetDto.getDescription();
//        this.items = closetDto.getItems();
//    }
//
//    public Closet(){
//
//    }
}
//Not finished?

//if I want in alphabetical use TreeSet