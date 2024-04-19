package com.lovecandle.demo.entitiy.dtos;

import com.lovecandle.demo.entitiy.Product;
import com.lovecandle.demo.entitiy.Resource;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ResourceDTO {

    private Long id;
    private String title;
    private String category;
    private String fragrance;
    private int amount;
    private Double price;
    private int quantityInStock;

    public ResourceDTO(Resource resource) {
        this.id = resource.getId();
        this.title = resource.getTitle();
        this.category = resource.getCategory();
        this.fragrance = resource.getFragrance();
        this.amount = resource.getAmount();
        this.price = resource.getPrice();
        this.quantityInStock = resource.getQuantityInStock();
    }
}