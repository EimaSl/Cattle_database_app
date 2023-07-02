package com.example.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Livestock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cattleName;
    private Double weight;
    private Double age;
    private String color;
    private LocalDate bornDate;
    private Boolean purebred;

    @Enumerated(EnumType.STRING)
    private LivestockType livestockType;

    @OneToMany(mappedBy = "livestock", cascade = CascadeType.ALL)
    private List<Image> imageList;

    @Transient
    private String imagePath;

    @OneToMany(mappedBy = "livestock", cascade = CascadeType.ALL)
    private Set<Meat> meatSet;
}

