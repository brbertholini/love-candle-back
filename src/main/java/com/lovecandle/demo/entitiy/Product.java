package com.lovecandle.demo.entitiy;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.lang.Nullable;

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

    @Nullable
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Nullable
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(@Nullable String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
