package com.lovecandle.demo.entitiy;

import com.lovecandle.demo.entitiy.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "RESOURCE_PRODUCT_MAPPING", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id"))
    private Set<Resource> resources; // Set<> usado para não ter repetição do mesmo Resource em um Produto

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
        this.resources = productDTO.getResources().stream().map(Resource::new).collect(Collectors.toSet());
    }

    public Product() {
    }
}