package com.lindsaySenia.lucyscloset.v1.model;

import com.lindsaySenia.lucyscloset.v1.entities.Closet;
import com.lindsaySenia.lucyscloset.v1.entities.Image;
import com.lindsaySenia.lucyscloset.v1.entities.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class ItemDto {

    private Long id;
    private String name;
    private String brand;
    private String type;
    private String size;
    private String color;
    private String imageUrl;
//    private List<Image> images;
//    private Set<Closet> closetSet;


    public ItemDto(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.brand = item.getBrand();
        this.type = item.getType();
        this.size = item.getSize();
        this.color = item.getColor();
        this.imageUrl = item.getImageUrl();
//        this.images = item.getImages();
//        this.closetSet = new HashSet<>();
    }

}
