package com.example.mapping.domain.model.repository;

import com.example.mapping.domain.model.entity.movement.MovementDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementDocumentRepository extends CrudRepository<MovementDocument, Long> {
}
