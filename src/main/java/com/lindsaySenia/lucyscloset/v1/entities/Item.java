package com.lindsaySenia.lucyscloset.v1.entities;

import com.lindsaySenia.lucyscloset.v1.model.ItemDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Item {
    public Item() {
    }

    public Item(ItemDto itemDto) {
        this.name = itemDto.getName();
        this.brand = itemDto.getBrand();
        this.type = itemDto.getType();
        this.size = itemDto.getSize();
        this.color = itemDto.getColor();
        this.imageUrl = itemDto.getImageUrl();
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String brand;
    private String type;
    private String size;
    private String color;
    private String imageUrl;


    @OneToMany(mappedBy = "item")
    private List<Image> images = new ArrayList<>();

    @ManyToMany(mappedBy = "items", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    private Set<Closet> closetSet;
//     = new HashSet<>();

//    public Item(ItemDto itemDto) {
//        this.name = itemDto.getName();
//        this.brand = itemDto.getBrand();
//        this.type = itemDto.getType();
//        this.size = itemDto.getSize();
//        this.color = itemDto.getColor();
//        this.images = itemDto.getImages();
//        this.closetSet = itemDto.getClosetSet();
//    }

}
