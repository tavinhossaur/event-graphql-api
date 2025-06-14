package com.ifsp.tavinho.event_graphql_api.infra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ifsp.tavinho.event_graphql_api.domain.dtos.EventDTO;
import com.ifsp.tavinho.event_graphql_api.domain.entities.Event;
import com.ifsp.tavinho.event_graphql_api.domain.usecases.CreateEventUseCase;
import com.ifsp.tavinho.event_graphql_api.domain.usecases.DeleteEventUseCase;
import com.ifsp.tavinho.event_graphql_api.domain.usecases.FindAllEventsUseCase;
import com.ifsp.tavinho.event_graphql_api.domain.usecases.FindEventByIdUseCase;
import com.ifsp.tavinho.event_graphql_api.domain.usecases.UpdateEventUseCase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

    private final FindAllEventsUseCase findAllEventsUseCase;
    private final FindEventByIdUseCase findEventByIdUseCase;
    private final CreateEventUseCase createEventUseCase;
    private final UpdateEventUseCase updateEventUseCase;
    private final DeleteEventUseCase deleteEventUseCase;

    public List<Event> findAllEvents() {
        return this.findAllEventsUseCase.execute();
    }

    public Event findEventById(String id) {
        return this.findEventByIdUseCase.execute(id);
    }

    public Event createEvent(EventDTO input) {
        return this.createEventUseCase.execute(input);
    }

    public Event updateEvent(String id, EventDTO input) {
        return this.updateEventUseCase.execute(id, input);
    }

    public Boolean deleteEvent(String id) {
        return this.deleteEventUseCase.execute(id);
    }

} 