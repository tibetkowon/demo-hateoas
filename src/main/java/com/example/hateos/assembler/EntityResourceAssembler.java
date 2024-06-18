package com.example.hateos.assembler;

import com.example.hateos.controller.EntityController;
import com.example.hateos.model.entity.Entity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EntityResourceAssembler implements RepresentationModelAssembler<Entity, EntityModel<Entity>> {
    @Override
    public EntityModel<Entity> toModel(Entity entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(EntityController.class).getEntity(entity.getId())).withSelfRel(),
                linkTo(methodOn(EntityController.class).getEntityList()).withRel("list"),
                linkTo(methodOn(EntityController.class).createEntity(entity)).withRel("create")
                );
    }
}
