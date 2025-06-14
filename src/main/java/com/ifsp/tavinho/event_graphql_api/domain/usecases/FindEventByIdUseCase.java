package com.ifsp.tavinho.event_graphql_api.domain.usecases;

import org.springframework.stereotype.Component;

import com.ifsp.tavinho.event_graphql_api.domain.entities.Event;
import com.ifsp.tavinho.event_graphql_api.infra.exceptions.EntityNotFoundException;
import com.ifsp.tavinho.event_graphql_api.domain.repositories.EventRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindEventByIdUseCase {
    
    private final EventRepository eventRepository;

    public Event execute(String id) {
        return this.eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event with id: " + id + " not found."));
    }
    
} 