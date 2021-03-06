package com.example.mapping.domain.message.core.error;

import java.io.Serializable;

public class ValidationError implements Serializable {

    private final long id;

    private final String message;

    public ValidationError(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
