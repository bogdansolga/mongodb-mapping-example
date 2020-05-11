package com.example.mapping.domain.model.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "order_item")
public class OrderItem extends AbstractOrchestratorEntity implements Comparable<OrderItem> {

    @Indexed
    private final long expeditionId;

    private final String sku;

    private final int quantity;

    @Indexed
    private long movementId;

    public OrderItem(long expeditionId, String sku, int quantity) {
        super();
        this.expeditionId = expeditionId;
        this.sku = sku;
        this.quantity = quantity;
    }

    public long getMovementId() {
        return movementId;
    }

    public void setMovementId(long movementId) {
        this.movementId = movementId;
    }

    public long getExpeditionId() {
        return expeditionId;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return expeditionId == orderItem.expeditionId &&
                quantity == orderItem.quantity &&
                sku.equals(orderItem.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expeditionId, sku, quantity);
    }

    @Override
    public int compareTo(OrderItem o) {
        return this.sku.compareTo(o.getSku());
    }
}
