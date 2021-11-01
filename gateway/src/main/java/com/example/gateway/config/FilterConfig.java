package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

//    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/service-admin/**")
                        .filters(f -> f.addRequestHeader("service-request", "service-admin-header")
                                .addResponseHeader("service-response", "service-admin-response"))
                        .uri("http://localhost:8001"))
                .route(r -> r.path("/service-user/**")
                        .filters(f -> f.addRequestHeader("service-request", "service-user-header")
                                .addResponseHeader("service-response", "service-user-response"))
                        .uri("http://localhost:9001"))
                .build();
    }
}
