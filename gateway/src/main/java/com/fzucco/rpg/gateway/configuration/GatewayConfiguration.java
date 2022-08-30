package com.fzucco.rpg.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

//    @Bean
//    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p.path("/get")
//                        .uri("http://httpbin.org:80"))
//                .build();
//    }
}
