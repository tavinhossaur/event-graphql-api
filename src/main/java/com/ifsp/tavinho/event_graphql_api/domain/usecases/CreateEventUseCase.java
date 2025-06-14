package com.ifsp.tavinho.event_graphql_api.domain.usecases;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.ifsp.tavinho.event_graphql_api.domain.dtos.EventDTO;
import com.ifsp.tavinho.event_graphql_api.domain.entities.Event;
import com.ifsp.tavinho.event_graphql_api.domain.repositories.EventRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateEventUseCase {
    
    private final EventRepository eventRepository;

    public Event execute(EventDTO input) {
        return this.eventRepository.save(
            new Event(
                input.description(),
                input.weekday(),
                LocalTime.parse(input.startTime()),
                LocalTime.parse(input.endTime()),
                input.classroomId(),
                input.professorId(),
                input.disciplineId(),
                input.courseId()
            )
        );
    }

} 