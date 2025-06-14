package com.ifsp.tavinho.event_graphql_api.domain.dtos;

public record EventDTO(
    String description,
    String weekday,
    String startTime,
    String endTime,
    String classroomId,
    String professorId,
    String courseId,
    String disciplineId
) {} 