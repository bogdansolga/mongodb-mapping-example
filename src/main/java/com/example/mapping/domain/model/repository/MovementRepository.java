package com.example.mapping.domain.model.repository;

import com.example.mapping.domain.model.entity.movement.Movement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Long> {
}
