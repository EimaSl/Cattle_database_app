package com.example.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Meat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amount;
    private Double weight;
    private Double totalWeight;
    private String color;

    @Enumerated(EnumType.STRING)
    private MeatType meatType;

    @Transient
    private String imagePath;

    @OneToMany(mappedBy = "meat", cascade = CascadeType.ALL) //ar tikrai "livestock"? jei pakeiciu i meat griuna viskas
    private List<Image> meatImageList;

    @ManyToOne()
    @JoinColumn(name = "livestock_id")
    @JsonIgnore
    private Livestock livestock;
}
