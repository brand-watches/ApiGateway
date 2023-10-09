package by.brandwatch.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        // define your routing rules here
        return builder.routes()
                .route("auth_routes", r -> r
                        .path("/api/v1/auth/**")
                        .uri("http://localhost:9090"))

                .route("settings_routes", r -> r
                        .path("/api/v1/settings/**")
                        .uri("http://localhost:8000"))

                .route("product_routes", r -> r
                        .path("/api/v1/product/**")
                        .uri("http://localhost:8000"))

                .route("order_routes", r -> r
                        .path("/api/v1/orders/**")
                        .uri("http://localhost:9000"))

                .route("sort_filter_routes", r -> r
                        .path("/api/v1/sortFilter/**")
                        .uri("http://localhost:8010"))
                .build();
    }
}