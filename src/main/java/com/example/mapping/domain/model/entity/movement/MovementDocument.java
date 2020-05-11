package com.example.mapping.domain.model.entity.movement;

import com.example.mapping.domain.model.entity.AbstractOrchestratorEntity;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Set;

@Document(collection = "movement_document")
public class MovementDocument extends AbstractOrchestratorEntity {

    @Indexed
    private final long expeditionId;

    @Indexed
    private final long invoiceId;

    @Indexed
    private final long movementDocumentId;

    @Indexed
    private final MovementType movementType;

    @Indexed
    private final long campaignId;

    @Indexed
    private int purchaseCenterId;

    @Indexed
    private int documentSourceId;

    @DBRef
    private Set<Movement> movements;

    public MovementDocument(final long expeditionId, final long invoiceId, final long movementDocumentId,
                            final MovementType movementType, final long campaignId) {
        super();
        this.expeditionId = expeditionId;
        this.invoiceId = invoiceId;
        this.movementDocumentId = movementDocumentId;
        this.movementType = movementType;
        this.campaignId = campaignId;
    }

    public long getExpeditionId() {
        return expeditionId;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public long getMovementDocumentId() {
        return movementDocumentId;
    }

    public Set<Movement> getMovements() {
        return movements;
    }

    public void setMovements(Set<Movement> movements) {
        this.movements = movements;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public long getCampaignId() {
        return campaignId;
    }

    public int getPurchaseCenterId() {
        return purchaseCenterId;
    }

    public void setPurchaseCenterId(int purchaseCenterId) {
        this.purchaseCenterId = purchaseCenterId;
    }

    public int getDocumentSourceId() {
        return documentSourceId;
    }

    public void setDocumentSourceId(int documentSourceId) {
        this.documentSourceId = documentSourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovementDocument that = (MovementDocument) o;
        return expeditionId == that.expeditionId &&
                invoiceId == that.invoiceId &&
                movementDocumentId == that.movementDocumentId &&
                campaignId == that.campaignId &&
                purchaseCenterId == that.purchaseCenterId &&
                documentSourceId == that.documentSourceId &&
                movementType == that.movementType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(expeditionId, invoiceId, movementDocumentId, movementType, campaignId, purchaseCenterId,
                documentSourceId);
    }
}
