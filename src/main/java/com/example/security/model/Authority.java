package com.example.security.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Authorities authority;
}
