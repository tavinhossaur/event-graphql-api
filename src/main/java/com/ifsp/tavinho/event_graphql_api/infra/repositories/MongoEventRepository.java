package com.ifsp.tavinho.event_graphql_api.infra.repositories;

import com.ifsp.tavinho.event_graphql_api.domain.entities.Event;
import com.ifsp.tavinho.event_graphql_api.domain.repositories.EventRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoEventRepository extends MongoRepository<Event, String>, EventRepository {
    // A implementação dos métodos da interface EventRepository é herdada do MongoRepository
} 