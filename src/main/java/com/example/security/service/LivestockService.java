package com.example.security.service;

import com.example.security.model.Image;
import com.example.security.model.Livestock;
import com.example.security.repository.ImageRepository;
import com.example.security.repository.LivestockRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class LivestockService {

    private final LivestockRepository livestockRepository;
    private final ImageRepository imageRepository;

    public Livestock getByCattleName(String cattleName){
        return livestockRepository.getByCattleName(cattleName);
    }

    public List<Livestock> getAllLivestock(){
        return livestockRepository.findAll();
    }

    public List<Livestock> addNewCattle(Livestock livestock){
        Image livestockImage = new Image();
        livestockImage.setLivestock(livestock);
        livestockImage.setImageAddress(livestock.getImagePath());
        livestock.setImageList(Arrays.asList(livestockImage));
        livestockRepository.save(livestock);
        return livestockRepository.findAll();
    }

    public List<Livestock> deleteCattle(Long livestockId){
        livestockRepository.deleteById(livestockId);
        return livestockRepository.findAll();
    }

    public List<Livestock> updateCattle(Livestock livestock){
        livestockRepository.save(livestock);
        return livestockRepository.findAll();
    }
}
