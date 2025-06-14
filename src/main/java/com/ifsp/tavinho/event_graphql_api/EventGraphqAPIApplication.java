package com.ifsp.tavinho.event_graphql_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.ifsp.tavinho.event_graphql_api.infra.repositories")
public class EventGraphqAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventGraphqAPIApplication.class, args);
	}

}
