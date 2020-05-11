package com.example.mapping.domain.model.entity.expedition;

import com.example.mapping.domain.model.entity.invoice.InvoiceOrder;
import com.example.mapping.domain.model.entity.AbstractOrchestratorEntity;
import com.example.mapping.domain.model.entity.Brand;
import com.example.mapping.domain.model.entity.OrderItem;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document(collection = "expedition")
public class Expedition extends AbstractOrchestratorEntity {

    @Indexed
    private Long expeditionId;

    @Indexed
    private ExpeditionStatus status;

    @Indexed
    private Brand brand;

    @Indexed
    private String warehouseCode;

    @Indexed
    private LocalDate expeditionDate;

    @DBRef
    private Set<OrderItem> orderItems;

    // the set of invoice orders is initially empty, as they are added after they are created
    @DBRef
    private Set<InvoiceOrder> invoiceOrders;

    private long totalExpeditionPieces;

    public Expedition(final Long expeditionId, final ExpeditionStatus status) {
        super();
        this.expeditionId = expeditionId;
        this.status = status;
        this.invoiceOrders = new HashSet<>();
    }

    public Long getExpeditionId() {
        return expeditionId;
    }

    public void setExpeditionId(Long expeditionId) {
        this.expeditionId = expeditionId;
    }

    public ExpeditionStatus getStatus() {
        return status;
    }

    public void setStatus(ExpeditionStatus status) {
        this.status = status;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setExpeditionDate(LocalDate expeditionDate) {
        this.expeditionDate = expeditionDate;
    }

    public LocalDate getExpeditionDate() {
        return expeditionDate;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public long getTotalExpeditionPieces() {
        return totalExpeditionPieces;
    }

    public void setTotalExpeditionPieces(long totalExpeditionPieces) {
        this.totalExpeditionPieces = totalExpeditionPieces;
    }

    public Set<InvoiceOrder> getInvoiceOrders() {
        return invoiceOrders;
    }

    public void setInvoiceOrders(Set<InvoiceOrder> invoiceOrders) {
        this.invoiceOrders = invoiceOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expedition that = (Expedition) o;
        return totalExpeditionPieces == that.totalExpeditionPieces &&
                expeditionId.equals(that.expeditionId) &&
                status == that.status &&
                brand == that.brand &&
                warehouseCode.equals(that.warehouseCode) &&
                expeditionDate.equals(that.expeditionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expeditionId, status, brand, warehouseCode, expeditionDate, totalExpeditionPieces);
    }
}
