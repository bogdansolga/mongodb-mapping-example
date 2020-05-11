package com.example.mapping.domain.model.entity.movement;

import com.example.mapping.domain.model.entity.AbstractOrchestratorEntity;
import com.example.mapping.domain.model.entity.OrderItem;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Set;

@Document(collection = "movement")
public class Movement extends AbstractOrchestratorEntity {

    @Indexed
    private final long movementDocumentId;

    @Indexed
    private final long movementId;

    @Indexed
    private final MovementStatus movementStatus;

    @DBRef
    private Set<OrderItem> orderItems;

    public Movement(final long movementDocumentId, final long movementId) {
        super();
        this.movementDocumentId = movementDocumentId;
        this.movementId = movementId;
        this.movementStatus = MovementStatus.Pending;
    }

    public long getMovementDocumentId() {
        return movementDocumentId;
    }

    public long getMovementId() {
        return movementId;
    }

    public MovementStatus getMovementStatus() {
        return movementStatus;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return movementDocumentId == movement.movementDocumentId &&
                movementId == movement.movementId &&
                movementStatus == movement.movementStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movementDocumentId, movementId, movementStatus);
    }
}
