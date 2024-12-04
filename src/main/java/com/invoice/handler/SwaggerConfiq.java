package com.invoice.handler;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiq {
    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder()
                .group("main-api")
                .pathsToMatch("/**")
                .packagesToExclude("com.invoice.handler") // Exclude handler package
                .build();
    }
}
