package com.example.mapping.domain.model.entity.invoice;

import com.example.mapping.domain.model.entity.AbstractOrchestratorEntity;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "invoice_order")
public class InvoiceOrder extends AbstractOrchestratorEntity {

    @Indexed
    private final long expeditionId;

    @Indexed
    private final long invoiceOrderId;

    @Indexed
    private InvoiceOrderStatus invoiceOrderStatus;

    private Invoice invoice;

    public InvoiceOrder(final long expeditionId, final long invoiceOrderId) {
        super();
        this.expeditionId = expeditionId;
        this.invoiceOrderId = invoiceOrderId;
        this.invoiceOrderStatus = InvoiceOrderStatus.Received;
    }

    public long getExpeditionId() {
        return expeditionId;
    }

    public long getInvoiceOrderId() {
        return invoiceOrderId;
    }

    public InvoiceOrderStatus getInvoiceOrderStatus() {
        return invoiceOrderStatus;
    }

    public void setInvoiceOrderStatus(InvoiceOrderStatus invoiceOrderStatus) {
        this.invoiceOrderStatus = invoiceOrderStatus;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceOrder that = (InvoiceOrder) o;
        return expeditionId == that.expeditionId &&
                invoiceOrderId == that.invoiceOrderId &&
                invoiceOrderStatus == that.invoiceOrderStatus &&
                Objects.equals(invoice, that.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expeditionId, invoiceOrderId, invoiceOrderStatus, invoice);
    }
}
