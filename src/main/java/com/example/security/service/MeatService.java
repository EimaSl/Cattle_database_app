package com.example.security.service;

import com.example.security.model.Image;
import com.example.security.model.Meat;
import com.example.security.repository.MeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class MeatService {

    private final MeatRepository meatRepository;

    public List<Meat> findAll() {

        return meatRepository.findAll();
    }

    public List<Meat> addNewMeat(Meat meat) {
        Image meatImage = new Image();
        meatImage.setMeat(meat);
        meatImage.setImageAddress(meat.getImagePath());
        meat.setMeatImageList(Arrays.asList(meatImage));
        meatRepository.save(meat);

//        List<Meat> meatList = meatRepository.findAll();
//        double totalWeight = calculateTotalMeatWeight(meatList);
//        System.out.println("Total Meat Weight: " + totalWeight);
//
//        return meatList;
        return meatRepository.findAll();
    }

//    public double calculateTotalMeatWeight(List<Meat> meatList) {
//        double totalWeight = 0.0;
//        for (Meat m : meatList) {
//            totalWeight += m.getWeight();
//        }
//        return totalWeight;
//    }

    public List<Meat> deleteMeat(Long meatId) {
        meatRepository.deleteById(meatId);
        return meatRepository.findAll();
    }
}
