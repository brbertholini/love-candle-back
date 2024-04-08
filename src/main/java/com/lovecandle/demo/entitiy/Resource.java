package com.lovecandle.demo.entitiy;

import com.lovecandle.demo.entitiy.dtos.ResourceDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="resources")
@Data
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String category;
    private String fragrance;
    private Double price;
    private int amount;
    private int quantityInStock;

    public Resource(ResourceDTO resourceDTO) {
        this.id = resourceDTO.getId();
        this.title = resourceDTO.getTitle();
        this.category = resourceDTO.getCategory();
        this.fragrance = resourceDTO.getFragrance();
        this.amount = resourceDTO.getAmount();
        this.price = resourceDTO.getPrice();
        this.quantityInStock = resourceDTO.getQuantityInStock();
    }

    public Resource() {
    }


    public Resource(Long id, String title, String category, String fragrance, int amount, Double price, int quantityInStock) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.fragrance = fragrance;
        this.amount = amount;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }
}


