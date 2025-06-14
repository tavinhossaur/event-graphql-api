package com.ifsp.tavinho.event_graphql_api.infra.configurations;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.core.convert.converter.Converter;

@Configuration
@EnableMongoAuditing
public class MongoConfig {
    
    @Bean
    MongoCustomConversions mongoCustomConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new LocalTimeToStringConverter());
        converters.add(new StringToLocalTimeConverter());
        return new MongoCustomConversions(converters);
    }
}

class LocalTimeToStringConverter implements Converter<LocalTime, String> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String convert(LocalTime source) {
        return source.format(formatter);
    }
}

class StringToLocalTimeConverter implements Converter<String, LocalTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public LocalTime convert(String source) {
        return LocalTime.parse(source, formatter);
    }
}
