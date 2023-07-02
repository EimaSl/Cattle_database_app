package com.example.security.controller;

import com.example.security.model.Image;
import com.example.security.model.Livestock;
import com.example.security.repository.ImageRepository;
import com.example.security.repository.LivestockRepository;
import com.example.security.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test2")
@Slf4j
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private LivestockRepository livestockRepository;

//    get image by cattle id

    @GetMapping("/cattle/{livestockId}/images")
    public List<Image> getAllImages(@PathVariable Long livestockId) {
        return imageService.getAllImages(livestockId);
    }

    @GetMapping("/meat/{meatId}/images")
    public List<Image> getAllMeatImages(@PathVariable Long meatId) {
        return imageService.getAllMeatImages(meatId);
    }


    //add image by cattle id

    @PostMapping("/admin/addImage")
    public List<Image> addNewImage(@RequestBody Image image) {
        return imageService.addNewImage(image);
    }
}
