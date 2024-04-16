package com.lovecandle.demo.entitiy.dtos;

import com.lovecandle.demo.entitiy.Product;
import com.lovecandle.demo.entitiy.Resource;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String title;
    private String category;
    private String fragrance;
    private int amount;
    private int weight;
    private String description;
    private Double price;
    private String imgUrl;
    private List<ResourceDTO> resources;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.category = product.getCategory();
        this.fragrance = product.getFragrance();
        this.amount = product.getAmount();
        this.weight = product.getWeight();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
        this.resources = product.getResources().stream().map(ResourceDTO::new).collect(Collectors.toList());
    }
}
