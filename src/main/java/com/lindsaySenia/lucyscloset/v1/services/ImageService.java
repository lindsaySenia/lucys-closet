package com.lindsaySenia.lucyscloset.v1.services;

import com.lindsaySenia.lucyscloset.v1.model.ImageDto;
import com.lindsaySenia.lucyscloset.v1.model.ItemDto;

import java.util.List;

public interface ImageService {
//    List<ImageDto> getAllImagesByItem(ItemDto item);

    ImageDto addImageToItem(ImageDto image);

    void deleteImageById(Long id);
}
