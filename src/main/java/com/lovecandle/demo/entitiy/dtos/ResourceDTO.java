package com.lovecandle.demo.entitiy.dtos;

import com.lovecandle.demo.entitiy.Product;
import com.lovecandle.demo.entitiy.Resource;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private ProductDTO productDTO;

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