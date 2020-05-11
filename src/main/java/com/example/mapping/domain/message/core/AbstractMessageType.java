package com.example.mapping.domain.message.core;

abstract class AbstractMessageType {
    abstract static class CommandMessage extends AbstractMessageType {
    }

    abstract static class DomainEventMessage extends AbstractMessageType {
    }
}