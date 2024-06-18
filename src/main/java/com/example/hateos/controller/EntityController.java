package com.example.hateos.controller;

import com.example.hateos.assembler.EntityResourceAssembler;
import com.example.hateos.model.entity.Entity;
import com.example.hateos.model.repository.EntityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entity")
@Slf4j
@RequiredArgsConstructor
public class EntityController {
    private final EntityResourceAssembler assembler;
    private final EntityRepository repository;

    @PostMapping
    public EntityModel<Entity> createEntity(@RequestBody Entity entity) {
        return assembler.toModel(repository.save(entity));
    }

    @GetMapping
    public CollectionModel<EntityModel<Entity>> getEntityList() {
        return assembler.toCollectionModel(repository.findAll());
    }


    @GetMapping("/{id}")
    public EntityModel<Entity> getEntity(@PathVariable Long id) {
        try {
            return assembler.toModel(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id))));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
