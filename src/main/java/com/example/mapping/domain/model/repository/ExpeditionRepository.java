package com.example.mapping.domain.model.repository;

import com.example.mapping.domain.model.entity.expedition.Expedition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpeditionRepository extends CrudRepository<Expedition, Long> {
}
