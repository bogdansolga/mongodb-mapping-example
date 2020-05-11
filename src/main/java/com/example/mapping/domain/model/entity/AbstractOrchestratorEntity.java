package com.example.mapping.domain.model.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class AbstractOrchestratorEntity implements Serializable {

    @Id
    @Indexed
    protected String id;

    @CreatedDate
    @Indexed
    protected LocalDateTime creationDateTime;

    public AbstractOrchestratorEntity() {
        this.creationDateTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }
}
