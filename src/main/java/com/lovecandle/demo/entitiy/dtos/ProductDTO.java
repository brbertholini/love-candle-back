package com.lovecandle.demo.entitiy.dtos;

import com.lovecandle.demo.entitiy.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

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
    @Nullable
    private String imgUrl;

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
    }
}
