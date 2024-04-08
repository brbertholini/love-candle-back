package com.lovecandle.demo.service;

import com.lovecandle.demo.entitiy.Product;
import com.lovecandle.demo.entitiy.dtos.ProductDTO;
import com.lovecandle.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() { return productRepository.findAll().stream().map(ProductDTO::new).toList(); }

    public Optional<ProductDTO> getProductById(Long id) { return productRepository.findById(id).map(ProductDTO::new);
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        return new ProductDTO(productRepository.save(new Product(productDTO)));
    }

    public Optional<ProductDTO> deleteProduct(Long id) {
        Optional<ProductDTO> productDTO = this.getProductById(id);
        productRepository.deleteById(id);
        return productDTO;

    }

    public ProductDTO updateProduct(Long id, ProductDTO obj) {
        Product entity = productRepository.getReferenceById(id);
        updateData(entity, new Product(obj));
        return new ProductDTO(productRepository.save(entity));
    }

    public void updateData(Product entity, Product obj) {
        entity.setTitle(obj.getTitle());
        entity.setCategory(obj.getCategory());
        entity.setFragrance(obj.getFragrance());
        entity.setAmount(obj.getAmount());
        entity.setWeight(obj.getWeight());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
    }
}
