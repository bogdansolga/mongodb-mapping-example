package com.example.mapping.domain.model.entity.invoice;

import com.example.mapping.domain.model.entity.AbstractOrchestratorEntity;
import com.example.mapping.domain.model.entity.movement.MovementDocument;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Objects;
import java.util.Set;

public class Invoice extends AbstractOrchestratorEntity {

    @Indexed
    private final long invoiceOrderId;

    @Indexed
    private final long invoiceId;

    @Indexed
    private InvoiceStatus invoiceStatus;

    @DBRef
    private Set<MovementDocument> movementDocuments;

    public Invoice(final long invoiceOrderId, final long invoiceId) {
        super();
        this.invoiceOrderId = invoiceOrderId;
        this.invoiceId = invoiceId;
        this.invoiceStatus = InvoiceStatus.Pending;
    }

    public long getInvoiceOrderId() {
        return invoiceOrderId;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Set<MovementDocument> getMovementDocuments() {
        return movementDocuments;
    }

    public void setMovementDocuments(Set<MovementDocument> movementDocuments) {
        this.movementDocuments = movementDocuments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceOrderId == invoice.invoiceOrderId &&
                invoiceId == invoice.invoiceId &&
                invoiceStatus == invoice.invoiceStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceOrderId, invoiceId, invoiceStatus);
    }
}
