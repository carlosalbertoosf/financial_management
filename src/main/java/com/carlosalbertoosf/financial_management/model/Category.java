package com.carlosalbertoosf.financial_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorie")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
