package com.example.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LivestockDTO {

    private Long id;
    private String cattleName;
    private Double weight;
    private Double age;
    private String color;
    private LocalDate bornDate;
    private Boolean purebred;
    @Enumerated(EnumType.STRING)
    private LivestockType livestockType;

    private String imagePath;
}
