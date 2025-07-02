package com.rdlts.jdk_feature.jdk8;

import lombok.extern.log4j.Log4j2;

import java.util.Optional;

@Log4j2
public class OptionalUsage {

    public static void demo() {
        createOptionalDemo();
        optionalMethodsDemo();
        chainingOperationsDemo();
    }

    private static void createOptionalDemo() {
        Optional<String> optionalValue = Optional.of("Hello, Optional!");
        Optional<String> emptyOptional = Optional.empty();

        log.info("Created Optional with value: {}", optionalValue);
        log.info("Created empty Optional: {}", emptyOptional);
    }

    private static void optionalMethodsDemo() {
        Optional<String> optionalValue = Optional.of("Hello, World!");

        // Check if value is present
//        log.info("Is value present? {}", optionalValue.isPresent());

        // Perform action if value is present
        optionalValue.ifPresent(value -> log.info("Value is present: {}", value));

        // Provide a default value if Optional is empty
        String defaultValue = optionalValue.orElse("Default Value");
        log.info("Value or default: {}", defaultValue);

        // Provide a default value using a supplier
        String suppliedValue = optionalValue.orElse(
                "Supplied Default Value");
        log.info("Value or supplied default: {}", suppliedValue);

        // Throw an exception if Optional is empty
        try {
            String value = optionalValue.orElseThrow(() -> new RuntimeException("Value is missing"));
            log.info("Value or exception: {}", value);
        } catch (RuntimeException e) {
            log.error("Exception thrown: {}", e.getMessage());
        }
    }

    private static void chainingOperationsDemo() {
        Optional<String> optionalValue = Optional.of("Hello");

        // Transform the value using map
        Optional<Integer> length = optionalValue.map(String::length);
        log.info("Length of value: {}", length.orElse(0));

        // Use flatMap for nested Optional
        Optional<String> nestedOptional = Optional.of("Nested");
        Optional<String> result = nestedOptional.flatMap(value -> Optional.of(value.toUpperCase()));
        log.info("Transformed nested value: {}", result.orElse("No Value"));
    }

}
