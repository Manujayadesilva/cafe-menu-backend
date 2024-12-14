// src/main/java/com/dev/skinnytomsacafe/dto/MenuItem.java
package com.dev.skinnytomsacafe.dto;

import jakarta.persistence.*;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ingredients;

    @Column(nullable = false)
    private Double price;

    @Lob
    @Column(nullable = false)
    private byte[] image;



    // Constructors
    public MenuItem() {}

    public MenuItem(Long id, Category category, String name, String ingredients, Double price, byte[] image) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.image = image;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}