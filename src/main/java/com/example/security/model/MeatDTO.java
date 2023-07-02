package com.example.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MeatDTO {

    private Long id;
    private Integer amount;
    private Double weight;
    private Double totalWeight;
    private String color;
    @Enumerated(EnumType.STRING)
    private MeatType meatType;

    @ManyToOne()
    @JoinColumn(name = "livestock_id")
    @JsonIgnore
    private Livestock livestock;

    private String imagePath;
}
