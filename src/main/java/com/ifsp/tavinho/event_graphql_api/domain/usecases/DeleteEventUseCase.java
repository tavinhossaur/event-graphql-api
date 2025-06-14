package com.ifsp.tavinho.event_graphql_api.domain.usecases;

import org.springframework.stereotype.Component;

import com.ifsp.tavinho.event_graphql_api.domain.repositories.EventRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteEventUseCase {
    
    private final EventRepository eventRepository;
    private final FindEventByIdUseCase findEventByIdUseCase;

    public Boolean execute(String id) {
        this.findEventByIdUseCase.execute(id); // Verifica se o registro existe.
        this.eventRepository.deleteById(id);
        return true;
    }

} 