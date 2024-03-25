package com.lovecandle.demo.entitiy;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private String category;

    private Double price;

    private String imgUrl;

    public Product() {
    }

    public Product(Long id, String title, String description, String category, Double price, String imgUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.imgUrl = imgUrl;
    }
}
