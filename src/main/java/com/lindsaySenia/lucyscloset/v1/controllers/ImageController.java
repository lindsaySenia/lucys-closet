package com.lindsaySenia.lucyscloset.v1.controllers;

import com.lindsaySenia.lucyscloset.v1.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor(onConstructor_={@Autowired})
public class ImageController {
    public final ImageService imageService;



}
