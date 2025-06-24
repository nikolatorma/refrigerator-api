package com.refrigerator.api;

import java.util.Optional;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresTestContainer {

    private static PostgreSQLContainer<?> container;

    private PostgresTestContainer() {
    }

    @SuppressWarnings("resource")
	public static synchronized PostgreSQLContainer<?> getInstance() {
        if (container == null) {
            container = new PostgreSQLContainer<>(getEnvOrDefault("POSTGRES_IMAGE", "postgres:16"))
                    .withDatabaseName(getEnvOrDefault("POSTGRES_DB", "refrigerator"))
                    .withUsername(getEnvOrDefault("POSTGRES_USER", "fridge_user"))
                    .withPassword(getEnvOrDefault("POSTGRES_PASSWORD", "fridge_pass"));
            container.start();

            Runtime.getRuntime().addShutdownHook(new Thread(container::stop));
        }
        return container;
    }

    private static String getEnvOrDefault(String key, String defaultValue) {
        return Optional.ofNullable(System.getenv(key)).orElse(defaultValue);
    }
}
