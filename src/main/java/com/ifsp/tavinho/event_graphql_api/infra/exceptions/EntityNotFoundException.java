package com.ifsp.tavinho.event_graphql_api.infra.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(final String message) {
        super(message);
    }
    
}
