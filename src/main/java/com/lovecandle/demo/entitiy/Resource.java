package com.lovecandle.demo.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lovecandle.demo.entitiy.dtos.ProductDTO;
import com.lovecandle.demo.entitiy.dtos.ResourceDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
}


