package com.lindsaySenia.lucyscloset.v1.entities;


import com.lindsaySenia.lucyscloset.v1.model.ImageDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {

    @Id
    @GeneratedValue
    private Long id;
//    @Column(name = "imageUrl", le)
    private String url;
    private String altTxt;

    @ManyToOne
    private Item item;

//    public Image(ImageDto imageDto) {
//        this.url = imageDto.getUrl();
//        this.altTxt = imageDto.getAltTxt();
//        this.item = imageDto.getItem();
//    }
//
//    public Image() {
//    }
}
