package com.example.mapping.domain.message.core;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractMessage<T extends AbstractMessageType> implements Serializable {

    protected static Set<InditexSystem> NONE = new HashSet<>();

    protected LocalDateTime creationDateTime;

    public abstract String getName();

    public abstract InditexSystem getSourceInditexSystem();

    public abstract Set<InditexSystem> getDestinationInditexSystems();

    public abstract MessageType getMessageType();

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }
}
