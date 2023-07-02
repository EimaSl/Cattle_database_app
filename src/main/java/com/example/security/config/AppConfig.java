package com.example.security.config;

import com.example.security.model.*;
import com.example.security.repository.AuthorityRepository;
import com.example.security.repository.LivestockRepository;
import com.example.security.repository.MeatRepository;
import com.example.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner commandLineRunner(LivestockRepository livestockRepository, UserRepository userRepository, MeatRepository meatRepository, AuthorityRepository authorityRepository) {
        return args -> {
            Livestock bull1 = new Livestock();
            bull1.setCattleName("Puntukas");
            bull1.setPurebred(true);
            bull1.setAge(1.5);
            bull1.setColor("Brown/yellow");
            bull1.setWeight(720.50);
            bull1.setBornDate(LocalDate.of(2022,1,5));
            bull1.setLivestockType(LivestockType.BULL);
            Image image1 = new Image();
            image1.setPhotographerName("Sigitas Navasinskas");
            image1.setImageAddress("http://localhost:1111/images/Bull/Aubrac.bull.mix2.lt.png");
            image1.setPlace("Niuronys");
            image1.setCreateDate(LocalDate.of(2023,2,10));
            image1.setLivestock(bull1);
            bull1.setImageList(Arrays.asList(image1));
            livestockRepository.save(bull1);

            Livestock bull2 = new Livestock();
            bull2.setCattleName("Julius");
            bull2.setPurebred(false);
            bull2.setAge(2.4);
            bull2.setColor("Brown");
            bull2.setWeight(952.00);
            bull2.setBornDate(LocalDate.of(2021,2,1));
            bull2.setLivestockType(LivestockType.BULL);
            Image image2 = new Image();
            image2.setPhotographerName("Sigitas Navasinskas");
            image2.setImageAddress("http://localhost:1111/images/Bull/Aubrac_bull4.jpeg");
            image2.setPlace("Paulinava");
            image2.setCreateDate(LocalDate.of(2023,2,10));
            image2.setLivestock(bull2);
            bull2.setImageList(Arrays.asList(image2));
            livestockRepository.save(bull2);

            Livestock cow1 = new Livestock();
            cow1.setCattleName("Irena");
            cow1.setPurebred(true);
            cow1.setAge(1.0);
            cow1.setColor("Pink/blue");
            cow1.setWeight(690.50);
            cow1.setBornDate(LocalDate.of(2022,7,1));
            cow1.setLivestockType(LivestockType.COW);
            Image image3 = new Image();
            image3.setPhotographerName("Adele Navasinskaite");
            image3.setImageAddress("http://localhost:1111/images/Cow/Aubrac_cow4.jpeg");
            image3.setPlace("Paulinava");
            image3.setCreateDate(LocalDate.of(2023,5,12));
            image3.setLivestock(cow1);
            cow1.setImageList(Arrays.asList(image3));
            livestockRepository.save(cow1);

            Livestock cow2 = new Livestock();
            cow2.setCattleName("Jurga");
            cow2.setPurebred(true);
            cow2.setAge(3.5);
            cow2.setColor("Brown/yellow");
            cow2.setWeight(620.50);
            cow2.setBornDate(LocalDate.of(2020,1,10));
            cow2.setLivestockType(LivestockType.COW);
            Image image4 = new Image();
            image4.setPhotographerName("Adele Navasinskaite");
            image4.setImageAddress("http://localhost:1111/images/Cow/Aubrac_cow2.jpeg");
            image4.setPlace("Niuronys");
            image4.setCreateDate(LocalDate.of(2023,5,12));
            image4.setLivestock(cow2);
            cow2.setImageList(Arrays.asList(image4));
            livestockRepository.save(cow2);

            Livestock calf1 = new Livestock();
            calf1.setCattleName("Mazius");
            calf1.setPurebred(false);
            calf1.setAge(0.5);
            calf1.setColor("Pink");
            calf1.setWeight(140.50);
            calf1.setBornDate(LocalDate.of(2023,1,25));
            calf1.setLivestockType(LivestockType.CALF);
            Image image5 = new Image();
            image5.setPhotographerName("Sigitas Navasinskas");
            image5.setImageAddress("http://localhost:1111/images/Calf/Aubrac_calf1.jpeg");
            image5.setPlace("Paulinava");
            image5.setCreateDate(LocalDate.of(2023,2,10));
            image5.setLivestock(calf1);
            calf1.setImageList(Arrays.asList(image5));
            livestockRepository.save(calf1);

            Meat meat1 = new Meat();
            meat1.setId(23456L);
            meat1.setAmount(5);
            meat1.setWeight(1.5);
            meat1.setTotalWeight(meat1.getAmount()*meat1.getWeight()); //???????
            meat1.setColor("Dark red");
            meat1.setMeatType(MeatType.HAM);
            meat1.setLivestock(bull1);
            Image image6 = new Image();
            image6.setPhotographerName("Sigitas Navasinskas");
            image6.setImageAddress("http://localhost:1111/images/Meat/Beef_Skirt_The_Aubrac.jpg");
            image6.setPlace("Paulinava");
            image6.setMeat(meat1);
            image6.setCreateDate(LocalDate.of(2023,5,11));
            meat1.setMeatImageList(Arrays.asList(image6));
            meatRepository.save(meat1);

            Meat meat2 = new Meat();
            meat2.setAmount(2);
            meat2.setWeight(2.5);
            meat2.setTotalWeight(meat2.getAmount()*meat1.getWeight());
            meat2.setColor("Red/white");
            meat2.setMeatType(MeatType.RIBS);
            meat2.setLivestock(bull2);
            Image image7 = new Image();
            image7.setPhotographerName("Eimantas Slizys");
            image7.setImageAddress("http://localhost:1111/images/Meat/Aubrac_shoulder.jpg");
            image7.setPlace("Paulinava");
            image7.setMeat(meat2);
            image7.setCreateDate(LocalDate.of(2023,6,2));
            meat2.setMeatImageList(Arrays.asList(image7));
            meatRepository.save(meat2);

            Meat meat3 = new Meat();
            meat3.setAmount(22);
            meat3.setWeight(0.5);
            meat3.setTotalWeight(meat3.getAmount()*meat1.getWeight());
            meat3.setColor("Mixed red");
            meat3.setMeatType(MeatType.MINCE);
            meat3.setLivestock(calf1);
            Image image8 = new Image();
            image8.setPhotographerName("Eimantas Slizys");
            image8.setImageAddress("http://localhost:1111/images/Meat/Aubrac_mince.jpg");
            image8.setPlace("Paulinava");
            image8.setMeat(meat3);
            image8.setCreateDate(LocalDate.of(2023,6,2));
            meat3.setMeatImageList(Arrays.asList(image8));
            meatRepository.save(meat3);

            Meat meat4 = new Meat();
            meat4.setAmount(2);
            meat4.setWeight(1.5);
            meat4.setTotalWeight(meat4.getAmount()*meat1.getWeight());
            meat4.setColor("Dark red");
            meat4.setMeatType(MeatType.ENTRECOTE);
            meat4.setLivestock(bull2);
            Image image9 = new Image();
            image9.setPhotographerName("Eimantas Slizys");
            image9.setImageAddress("http://localhost:1111/images/Meat/Aubrac_Entrecote_Beef.jpg");
            image9.setPlace("Paulinava");
            image9.setMeat(meat4);
            image9.setCreateDate(LocalDate.of(2023,6,2));
            meat4.setMeatImageList(Arrays.asList(image9));
            meatRepository.save(meat4);

            Meat meat5 = new Meat();
            meat5.setAmount(15);
            meat5.setWeight(2.0);
            meat5.setTotalWeight(meat5.getAmount()*meat1.getWeight());
            meat5.setColor("Red/white");
            meat5.setMeatType(MeatType.SIRLOIN);
            meat5.setLivestock(cow1);
            Image image10 = new Image();
            image10.setPhotographerName("Eimantas Slizys");
            image10.setImageAddress("http://localhost:1111/images/Meat/Aubrac_Beef_Fillet.jpg");
            image10.setPlace("Paulinava");
            image10.setMeat(meat5);
            image10.setCreateDate(LocalDate.of(2023,6,2));
            meat5.setMeatImageList(Arrays.asList(image10));
            meatRepository.save(meat5);

            Meat meat6 = new Meat();
            meat6.setAmount(2);
            meat6.setWeight(2.5);
            meat6.setTotalWeight(meat6.getAmount()*meat1.getWeight());
            meat6.setColor("Red/white");
            meat6.setMeatType(MeatType.SHOULDER);
            meat6.setLivestock(bull2);
            Image image11 = new Image();
            image11.setPhotographerName("Eimantas Slizys");
            image11.setImageAddress("http://localhost:1111/images/Meat/meat1.jpeg");
            image11.setPlace("Paulinava");
            image11.setMeat(meat6);
            image11.setCreateDate(LocalDate.of(2023,6,2));
            meat6.setMeatImageList(Arrays.asList(image11));
            meatRepository.save(meat6);

            Meat meat7 = new Meat();
            meat7.setAmount(2);
            meat7.setWeight(2.5);
            meat7.setTotalWeight(meat7.getAmount()*meat1.getWeight());
            meat7.setColor("Red/white");
            meat7.setMeatType(MeatType.HEEL);
            meat7.setLivestock(cow2);
            Image image12 = new Image();
            image12.setPhotographerName("Eimantas Slizys");
            image12.setImageAddress("http://localhost:1111/images/Meat/Aubrac_heel.jpg");
            image12.setPlace("Paulinava");
            image12.setMeat(meat7);
            image12.setCreateDate(LocalDate.of(2023,6,2));
            meat7.setMeatImageList(Arrays.asList(image12));
            meatRepository.save(meat7);


            User simpleUser = new User();
            simpleUser.setUsername("Svecias");
            simpleUser.setPassword(new BCryptPasswordEncoder().encode("svecias"));
            simpleUser.setEnabled(true);
            Authority authority = new Authority();
            authority.setAuthority(Authorities.USER);
            simpleUser.setAuthorities(Collections.singleton(authority));
            userRepository.save(simpleUser);

            User adminUser = new User();
            adminUser.setUsername("Eimantas");
            adminUser.setPassword(new BCryptPasswordEncoder().encode("eimantas"));
            adminUser.setEnabled(true);
            Authority authorityAdmin = new Authority();
            authorityAdmin.setAuthority(Authorities.ADMIN);
            adminUser.setAuthorities(Collections.singleton(authorityAdmin));
            userRepository.save(adminUser);
        };
    }
}
