package com.example.security.controller;

import com.example.security.model.*;
import com.example.security.repository.LivestockRepository;
import com.example.security.repository.MeatRepository;
import com.example.security.service.AuthenticationService;
import com.example.security.service.LivestockService;
import com.example.security.service.MeatService;
import com.example.security.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
@Slf4j
public class LivestockController {

    @Autowired
    private LivestockRepository livestockRepository;
    @Autowired
    private MeatRepository meatRepository;
    @Autowired
    private LivestockService livestockService;
    @Autowired
    private MeatService meatService;

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @GetMapping("/greeting")
    public String showGreeting() {
        return "Welcome to cattle structure analysis database!";
    }

    @GetMapping("/cattle")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<LivestockDTO> getAllCattle() {
//        String username = authenticationService.getUserName();
//        User user = userService.getByUsername(username);
//        return userService.getAllCattle(user.getId());
        List<Livestock> allCattles = livestockRepository.findAll();
        List<LivestockDTO> allCattlesDTO = new ArrayList<>();
        for (Livestock singleCattle : allCattles) {
            LivestockDTO livestockDTO = new LivestockDTO();
            livestockDTO.setId(singleCattle.getId());
            livestockDTO.setCattleName(singleCattle.getCattleName());
            livestockDTO.setImagePath(singleCattle.getImageList().get(0).getImageAddress());
            livestockDTO.setAge(singleCattle.getAge());
            livestockDTO.setColor(singleCattle.getColor());
            livestockDTO.setLivestockType(singleCattle.getLivestockType());
            livestockDTO.setPurebred(singleCattle.getPurebred());
            livestockDTO.setBornDate(singleCattle.getBornDate());
            livestockDTO.setWeight(singleCattle.getWeight());
            allCattlesDTO.add(livestockDTO);
        }
        return allCattlesDTO;
    }

    @GetMapping("/meat")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<MeatDTO> getAllMeat() {
        List<Meat> allMeat = meatRepository.findAll();
        List<MeatDTO> allMeatDTO = new ArrayList<>();
        for (Meat singleMeat : allMeat) {
            MeatDTO meatDTO = new MeatDTO();
            meatDTO.setId(singleMeat.getId());
            meatDTO.setAmount(singleMeat.getAmount());
            meatDTO.setImagePath(singleMeat.getMeatImageList().get(0).getImageAddress());
            meatDTO.setColor(singleMeat.getColor());
            meatDTO.setMeatType(singleMeat.getMeatType());
            meatDTO.setLivestock(singleMeat.getLivestock());
            meatDTO.setWeight(singleMeat.getWeight());
            meatDTO.setTotalWeight(singleMeat.getWeight()*singleMeat.getAmount());
            allMeatDTO.add(meatDTO);
        }
        return allMeatDTO;
    }

    @GetMapping("/")
    public List<Meat> findAll() {
        return meatService.findAll();
    }

    @GetMapping("/admin")
    public String showAdminOptions() {
        return "Admin page";
    }

    @PostMapping("/admin/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Livestock> addNewCattle(@RequestBody Livestock livestock) {
        log.info(String.valueOf(livestock));
        return livestockService.addNewCattle(livestock);
    }

    @PostMapping("/admin/add2")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Meat> addNewMeat(@RequestBody Meat meat) {
        log.info(String.valueOf(meat));
        return meatService.addNewMeat(meat);
    }

    @DeleteMapping("/admin/delete/{livestockId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Livestock> deleteCattle(@PathVariable Long livestockId) {
        return livestockService.deleteCattle(livestockId);
    }

    @DeleteMapping("/admin/delete2/{meatId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Meat> deleteMeat(@PathVariable Long meatId) {
        return meatService.deleteMeat(meatId);
    }

    @PutMapping("/admin/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Livestock> updateCattle(@RequestBody Livestock livestock) {
        log.info(String.valueOf(livestock));
        return livestockService.updateCattle(livestock);
    }
}

