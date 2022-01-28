package com.lindsaySenia.lucyscloset.v1.services;

import com.lindsaySenia.lucyscloset.v1.entities.Image;
import com.lindsaySenia.lucyscloset.v1.model.ImageDto;
import com.lindsaySenia.lucyscloset.v1.repositories.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor(onConstructor_={@Autowired})
public class ImageServiceImpl implements ImageService{
        private final ImageRepository imageRepository;


        @Override
        public ImageDto addImageToItem(ImageDto imageDto) {
            Image image = new Image();
            image.setUrl(imageDto.getUrl());
            image.setAltTxt(imageDto.getAltTxt());
//            image.setItem(imageDto.getItem());

            return new ImageDto(imageRepository.save(image));

        }

    @Override
    public void deleteImageById(Long id) {

    }


}
