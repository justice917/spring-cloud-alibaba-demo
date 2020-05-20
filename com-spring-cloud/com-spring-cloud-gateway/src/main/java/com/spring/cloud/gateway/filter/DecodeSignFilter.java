package com.spring.cloud.gateway.filter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class DecodeSignFilter implements GlobalFilter,Ordered{

	private static final Logger LOGGER = LoggerFactory.getLogger(DecodeSignFilter.class);
	
	@Override
	public int getOrder() {		
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		LOGGER.info(exchange.toString());
		LOGGER.info(chain.toString());
		HttpHeaders headers = exchange.getRequest().getHeaders();
		List<String> xsign = headers.get("X-sign");
		if(CollectionUtils.isNotEmpty(xsign)){
			for(String one : xsign){
				LOGGER.info("xsign = "+one);
			}
		}
		
		return chain.filter(exchange);
	}

}
