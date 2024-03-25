package com.lovecandle.demo.service;

import com.lovecandle.demo.entitiy.Product;
import com.lovecandle.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        // fazer exception
        return obj.orElse(null);
    }

    public Product saveProduct(Product obj) {
        return productRepository.save(obj);
    }

    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            // fazer exception
            return;
        }
    }

    public Product updateProduct(Long id, Product obj) {
        Product entity = productRepository.getReferenceById(id);
        updateData(entity, obj);
        return productRepository.save(entity);
    }

    public void updateData(Product entity, Product obj) {
        entity.setTitle(obj.getTitle());
        entity.setDescription(obj.getDescription());
        entity.setCategory(obj.getCategory());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
    }
}
