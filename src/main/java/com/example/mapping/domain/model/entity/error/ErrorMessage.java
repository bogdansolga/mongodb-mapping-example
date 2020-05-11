package com.example.mapping.domain.model.entity.error;

import com.example.mapping.domain.message.core.InditexSystem;
import com.example.mapping.domain.message.core.error.ValidationError;
import com.example.mapping.domain.message.core.error.ProcessingError;
import com.example.mapping.domain.model.entity.AbstractOrchestratorEntity;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "error_message")
public class ErrorMessage extends AbstractOrchestratorEntity {

    @Indexed
    private String inboundMessageId;

    @Indexed
    private InditexSystem sourceSystem;

    private Set<ValidationError> validationErrors;

    private Set<ProcessingError> processingErrors;

    public ErrorMessage(final String inboundMessageId, final InditexSystem sourceSystem) {
        super();
        this.inboundMessageId = inboundMessageId;
        this.sourceSystem = sourceSystem;
    }

    public String getInboundMessageId() {
        return inboundMessageId;
    }

    public void setInboundMessageId(String inboundMessageId) {
        this.inboundMessageId = inboundMessageId;
    }

    public InditexSystem getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(InditexSystem sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public Set<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Set<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public Set<ProcessingError> getProcessingErrors() {
        return processingErrors;
    }

    public void setProcessingErrors(Set<ProcessingError> processingErrors) {
        this.processingErrors = processingErrors;
    }
}
