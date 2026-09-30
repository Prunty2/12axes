package com.twelveaxes.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer rejectNumericEnums() {
        // Answer values must use their names, never Jackson's implicit enum ordinals.
        return builder -> builder.featuresToEnable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
    }
}
