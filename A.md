# Event GraphQL API

GraphQL API for managing the "Event" entity from the Tutor Monitoring System database.

## Description

This API provides a GraphQL interface to manage events, allowing CRUD operations in a MongoDB database. The API was built using Spring Boot.

## Technologies Used

- Java 21
- Spring Boot 3.5.0
- Spring GraphQL
- MongoDB
- Maven
- Lombok

## Prerequisites

- Java 21 or higher
- MongoDB installed and running locally on port 27017
- Maven

## Environment Setup

- Clone the repository:

```bash
git clone [REPOSITORY_URL]
cd event-graphql-api
```

- Configure MongoDB:

- Make sure MongoDB connection string is properly configured.

- Run the project:

```bash
./mvnw spring-boot:run
```

The application will be available at `http://localhost:8080`

## Project Structure

```bash
src/main/java/com/ifsp/tavinho/event_graphql_api/
├── domain/
│   ├── dtos/
│   ├── entities/
│   ├── repositories/
│   └── usecases/
├── infra/
│   ├── configurations/
│   ├── controllers/
│   ├── exceptions/
│   ├── repositories/
│   └── services/
└── EventGraphqAPIApplication.java
```

## GraphQL API

### Available Queries

- `events`: Returns all events
- `event(id: ID!)`: Returns a specific event by ID

### Available Mutations

- `createEvent(input: EventInput!)`: Creates a new event
- `updateEvent(id: ID!, input: EventInput!)`: Updates an existing event
- `deleteEvent(id: ID!)`: Removes an event

### GraphQL Schema

```graphql
type Event {
    id: ID!
    description: String!
    weekday: String!
    startTime: String!
    endTime: String!
    classroomId: String!
    professorId: String!
    courseId: String!
    disciplineId: String!
    createdAt: String!
    updatedAt: String!
}

input EventInput {
    description: String!
    weekday: String!
    startTime: String!
    endTime: String!
    classroomId: String!
    professorId: String!
    courseId: String!
    disciplineId: String!
}
```

## GraphiQL Interface

The API includes a GraphiQL interface for testing queries and mutations.

```bash
http://localhost:8080/graphiql
```

You can also test the API using Postman / Insomnia by importing the collection file available at:

```bash
graphql_api.postman_collection.json
```

This file contains examples of all available API operations:

- List all events
- Get event by ID
- Create new event
- Update existing event
- Delete event

## Usage Examples

### Create an Event

```graphql
mutation {
  createEvent(input: {
    description: "Programming Class",
    weekday: "monday", # monday, tuesday, wednesday...
    startTime: "08:00", # HH:mm
    endTime: "10:00", # HH:mm
    classroomId: "123",
    professorId: "456",
    courseId: "789",
    disciplineId: "101"
  }) {
    id
    description
    weekday
    startTime
    endTime
  }
}
```

### Get All Events

```graphql
query {
  events {
    id
    description
    weekday
    startTime
    endTime
  }
}
```

### Get Event by ID

```graphql
query {
  event(id: "event_id") {
    id
    description
    weekday
    startTime
    endTime
  }
}
```

## License

This project is under the MIT license.
