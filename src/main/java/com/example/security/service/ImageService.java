package com.example.security.service;

import com.example.security.model.Image;
import com.example.security.model.Livestock;
import com.example.security.repository.ImageRepository;
import com.example.security.repository.LivestockRepository;
import com.example.security.repository.MeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ImageService {

    @Autowired
    private final ImageRepository imageRepository;
    @Autowired
    private final LivestockRepository livestockRepository;
    @Autowired
    private  final MeatRepository meatRepository;

    public List<Image> getAllImages(Long livestockId){
        return livestockRepository.findById(livestockId).get().getImageList();
    }

    public List<Image> addNewImage(Image image){
        Livestock livestock = livestockRepository.findById(image.getLivestockId()).get();
        image.setLivestock(livestock);
        livestock.getImageList().add(image);
        livestockRepository.save(livestock);
        return livestockRepository.findById(image.getLivestockId()).get().getImageList();
    }

    public List<Image> getAllMeatImages(Long meatId) {
        return meatRepository.findById(meatId).get().getMeatImageList();
    }
}
