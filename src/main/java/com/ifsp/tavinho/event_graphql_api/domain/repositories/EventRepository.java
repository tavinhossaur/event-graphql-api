package com.ifsp.tavinho.event_graphql_api.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.ifsp.tavinho.event_graphql_api.domain.entities.Event;

public interface EventRepository {
    Event save(Event event);
    Optional<Event> findById(String id);
    List<Event> findAll();
    void deleteById(String id);
    boolean existsById(String id);
} 