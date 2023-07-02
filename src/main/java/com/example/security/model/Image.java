package com.example.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photographerName;
    private String place;
    private String imageAddress;
    private LocalDate createDate;

    @ManyToOne()
    @JoinColumn(name = "livestock_Id")
    @JsonIgnore
    private Livestock livestock;

    @ManyToOne()
    @JoinColumn(name = "meat_Id")
    @JsonIgnore
    private Meat meat;

    @Transient
    private Long livestockId;

    @Transient
    private Long meatId;
}
