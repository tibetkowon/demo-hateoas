package com.example.hateos.model.repository;

import com.example.hateos.model.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends JpaRepository<Entity, Long> {
}
