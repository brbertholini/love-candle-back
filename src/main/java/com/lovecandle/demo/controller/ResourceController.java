package com.lovecandle.demo.controller;

import com.lovecandle.demo.entitiy.dtos.ResourceDTO;
import com.lovecandle.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(value = "/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;


    @GetMapping
    public ResponseEntity<List<ResourceDTO>> getAllResources() {
        List<ResourceDTO> list = resourceService.getAllResources();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResourceDTO> getResourceById(@PathVariable Long id) {
        Optional<ResourceDTO> resourceDTO = resourceService.getResourceById(id);

        if (resourceDTO.isPresent()) {
            return ResponseEntity.ok().body(resourceDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<ResourceDTO> saveResource(@RequestBody ResourceDTO obj) {
        obj = resourceService.saveResource(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResourceDTO> updateResource(@PathVariable Long id, @RequestBody ResourceDTO obj) {
        obj = resourceService.updateResource(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        Optional<ResourceDTO> resourceDTO = resourceService.deleteResource(id);
        if (resourceDTO.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
