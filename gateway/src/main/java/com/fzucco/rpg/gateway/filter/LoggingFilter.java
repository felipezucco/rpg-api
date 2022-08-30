package com.fzucco.rpg.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("RequestPath: {}", exchange.getRequest().getPath());
        logger.info("Host: {}", exchange.getRequest().getURI().getHost());
        logger.info("PORT: {}", exchange.getRequest().getURI().getPort());

        return chain.filter(exchange);
    }
}
