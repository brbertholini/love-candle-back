package com.lovecandle.demo.service;

import com.lovecandle.demo.entitiy.Product;
import com.lovecandle.demo.entitiy.Resource;
import com.lovecandle.demo.entitiy.dtos.ProductDTO;
import com.lovecandle.demo.entitiy.dtos.ResourceDTO;
import com.lovecandle.demo.repository.ProductRepository;
import com.lovecandle.demo.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public ResourceRepository resourceRepository;

    public List<ProductDTO> getAllProducts() { return productRepository.findAll().stream().map(ProductDTO::new).toList(); }

    public Optional<ProductDTO> getProductById(Long id) { return productRepository.findById(id).map(ProductDTO::new);
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);

        // lista para armazenar os recursos associados
        List<Resource> associatedResources = new ArrayList<>();

        // loop pelos recursos do DTO
        for (ResourceDTO resourceDTO : productDTO.getResources()) {
            // verifica se o ID do recurso existe
            if (resourceDTO.getId() != null) {
                // busca o recurso no banco
                Optional<Resource> optionalResource = resourceRepository.findById(resourceDTO.getId());
                optionalResource.ifPresent(associatedResources::add); // adiciona o recurso encontrado à lista
            } else {
                // caso o ID do recurso não exista
                Resource newResource = new Resource(resourceDTO);
                newResource.setProduct(product); // define o produto para o novo recurso
                associatedResources.add(newResource); // adiciona o novo recurso à lista
            }
        }
        // define a lista de recursos atualizada
        product.setResources(associatedResources);

        product = productRepository.save(product);

        return new ProductDTO(product);
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
