package com.example.mapping.domain.message.core;

public abstract class AbstractDomainEvent extends AbstractMessage<AbstractMessageType.DomainEventMessage> {

    @Override
    public MessageType getMessageType() {
        return MessageType.DOMAIN_EVENT;
    }
}
