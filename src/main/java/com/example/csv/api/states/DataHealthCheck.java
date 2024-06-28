package com.example.csv.api.states;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;


@Liveness
@ApplicationScoped
public class DataHealthCheck implements HealthCheck {

    @ConfigProperty(name = "quarkus.application.name", defaultValue = "hacken-test")
    String name;


    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Health Check with data")
                .up()
                .withData("api", name)
                .build();
    }
}
