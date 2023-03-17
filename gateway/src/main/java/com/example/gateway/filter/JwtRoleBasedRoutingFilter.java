package com.example.gateway.filter;

import com.example.gateway.security.JwtTokenProvider;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtRoleBasedRoutingFilter implements GatewayFilter {

    private final JwtDecoder jwtDecoder;

    public JwtRoleBasedRoutingFilter(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = extractToken(exchange.getRequest());
        if (StringUtils.hasText(token)) {
            Jwt jwt = jwtDecoder.decode(token);
            String role = jwt.getClaim("role");
            String path = exchange.getRequest().getPath().value();
            if (path.startsWith("/api")) {
                if ("ROLE_ADMIN".equals(role)) {
                    exchange.getRequest().mutate().path("/admin" + path).build();
                } else if ("ROLE_USER".equals(role)) {
                    exchange.getRequest().mutate().path("/user" + path).build();
                }
            }
        }
        return chain.filter(exchange);
    }

    private String extractToken(ServerHttpRequest request) {
        String bearerToken = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
