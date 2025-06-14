package com.ifsp.tavinho.event_graphql_api.domain.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ifsp.tavinho.event_graphql_api.domain.entities.Event;
import com.ifsp.tavinho.event_graphql_api.domain.repositories.EventRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAllEventsUseCase {
    
    private final EventRepository eventRepository;

    public List<Event> execute() {
        return this.eventRepository.findAll();
    }

} 