package com.lovecandle.demo.service;

import com.lovecandle.demo.entitiy.Resource;
import com.lovecandle.demo.entitiy.dtos.ResourceDTO;
import com.lovecandle.demo.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    @Autowired
    public ResourceRepository resourceRepository;

    public List<ResourceDTO> getAllResources() { return resourceRepository.findAll().stream().map(ResourceDTO::new).toList(); }

    public Optional<ResourceDTO> getResourceById(Long id) { return resourceRepository.findById(id).map(ResourceDTO::new);
    }

    public ResourceDTO saveResource(ResourceDTO resourceDTO) {
        return new ResourceDTO(resourceRepository.save(new Resource(resourceDTO)));
    }

    public Optional<ResourceDTO> deleteResource(Long id) {
        Optional<ResourceDTO> resourceDTO = this.getResourceById(id);
        resourceRepository.deleteById(id);
        return resourceDTO;

    }

    public ResourceDTO updateResource(Long id, ResourceDTO obj) {
        Resource entity = resourceRepository.getReferenceById(id);
        updateData(entity, new Resource(obj));
        return new ResourceDTO(resourceRepository.save(entity));
    }

    public void updateData(Resource entity, Resource obj) {
        entity.setTitle(obj.getTitle());
        entity.setCategory(obj.getCategory());
        entity.setFragrance(obj.getFragrance());
        entity.setAmount(obj.getAmount());
        entity.setPrice(obj.getPrice());
        entity.setQuantityInStock(obj.getQuantityInStock());
    }
}
