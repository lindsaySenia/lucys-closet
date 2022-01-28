package com.lindsaySenia.lucyscloset.v1.model;

import com.lindsaySenia.lucyscloset.v1.entities.Image;
import com.lindsaySenia.lucyscloset.v1.entities.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageDto {

    private Long id;
    private String url;
    private String altTxt;
    private Item item;

    public ImageDto(Image image) {
        this.id = image.getId();
        this.url = image.getUrl();
        this.altTxt = image.getAltTxt();
        this.item = image.getItem();
    }
}
