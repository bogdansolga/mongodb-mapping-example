package com.example.mapping.domain.message.core;

public abstract class AbstractCommand extends AbstractMessage<AbstractMessageType.CommandMessage> {

    @Override
    public MessageType getMessageType() {
        return MessageType.COMMAND;
    }
}
