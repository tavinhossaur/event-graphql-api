package com.ifsp.tavinho.event_graphql_api.infra.controllers;

import java.util.List;

import com.ifsp.tavinho.event_graphql_api.infra.services.EventService;
import com.ifsp.tavinho.event_graphql_api.domain.entities.Event;
import com.ifsp.tavinho.event_graphql_api.domain.dtos.EventDTO;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @QueryMapping
    public List<Event> events() {
        return this.eventService.findAllEvents();
    }

    @QueryMapping
    public Event event(@Argument String id) {
        return this.eventService.findEventById(id);
    }

    @MutationMapping
    public Event createEvent(@Argument("input") EventDTO input) {
        return this.eventService.createEvent(input);
    }

    @MutationMapping
    public Event updateEvent(@Argument String id, @Argument("input") EventDTO input) {
        return this.eventService.updateEvent(id, input);
    }

    @MutationMapping
    public Boolean deleteEvent(@Argument String id) {
        return this.eventService.deleteEvent(id);
    }

} 