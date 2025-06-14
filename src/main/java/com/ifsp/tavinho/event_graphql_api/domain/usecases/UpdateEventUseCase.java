package com.ifsp.tavinho.event_graphql_api.domain.usecases;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.ifsp.tavinho.event_graphql_api.domain.dtos.EventDTO;
import com.ifsp.tavinho.event_graphql_api.domain.entities.Event;
import com.ifsp.tavinho.event_graphql_api.domain.repositories.EventRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateEventUseCase {
    
    private final EventRepository eventRepository;
    private final FindEventByIdUseCase findEventByIdUseCase;

    public Event execute(String id, EventDTO input) {
        Event existingEvent = this.findEventByIdUseCase.execute(id);

        if (input.description() != null) existingEvent.setDescription(input.description());
        if (input.weekday() != null) existingEvent.setWeekday(input.weekday());
        if (input.startTime() != null) existingEvent.setStartTime(LocalTime.parse(input.startTime()));
        if (input.endTime() != null) existingEvent.setEndTime(LocalTime.parse(input.endTime()));
        if (input.classroomId() != null) existingEvent.setClassroomId(input.classroomId());
        if (input.professorId() != null) existingEvent.setProfessorId(input.professorId());
        if (input.courseId() != null) existingEvent.setCourseId(input.courseId());
        if (input.disciplineId() != null) existingEvent.setDisciplineId(input.disciplineId());

        return this.eventRepository.save(existingEvent);
    }

} 