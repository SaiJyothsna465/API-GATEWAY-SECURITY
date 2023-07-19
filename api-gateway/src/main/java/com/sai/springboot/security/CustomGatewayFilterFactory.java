package com.sai.springboot.security;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

@Component
public class CustomGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomGatewayFilterFactory.Config> {

	private static final Logger logger = LoggerFactory.getLogger(CustomGatewayFilterFactory.class);

	public CustomGatewayFilterFactory() {
		super(Config.class);
	}
	
	public static class Config {

	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			ServerHttpResponse response = exchange.getResponse();

			logger.info("Outgoing response: {}", request.getMethod(), 
					request.getURI().getPath());
			logger.debug("Request header: {}", request.getHeaders());

			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("Path of the request received -> {}", request.getPath());
				logger.info("Outgoing response: {}", response.getStatusCode());
				logger.debug("Response headers: {}", response.getHeaders());
			}));

		};
	}

	
}
