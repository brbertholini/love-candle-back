package com.lovecandle.demo.entitiy;

import com.lovecandle.demo.entitiy.dtos.ProductDTO;
import com.lovecandle.demo.entitiy.dtos.UserDTO;
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
    private String category;
    private String fragrance;
    private int amount;
    private int weight;
    private String description;
    private Double price;
    @Nullable
    private String imgUrl;

    public Product(ProductDTO productDTO) {
        this.id = productDTO.getId();
        this.title = productDTO.getTitle();
        this.category = productDTO.getCategory();
        this.fragrance = productDTO.getFragrance();
        this.amount = productDTO.getAmount();
        this.weight = productDTO.getWeight();
        this.description = productDTO.getDescription();
        this.price = productDTO.getPrice();
        this.imgUrl = productDTO.getImgUrl();
    }

    public Product() {
    }

    public Product(Long id, String title, String category, String fragrance, int amount, int weight, String description, Double price, @Nullable String imgUrl) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.fragrance = fragrance;
        this.amount = amount;
        this.weight = weight;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }
}