package com.rdlts.jdk_feature.jdk8;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class LambdaExpression {

    public static void demo() {
        sortDemo();
        filterDemo();
        customFunctionalInterfaceDemo();
    }

    private static void sortDemo() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        log.info("Original list: {}", names);

        List<String> sortedNames = names.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        log.info("Sorted list: {}", sortedNames);
    }

    private static void filterDemo() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        log.info("Original list: {}", numbers);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        log.info("Filtered list (even numbers): {}", evenNumbers);
    }

    private static void customFunctionalInterfaceDemo() {
        MyFunctionalInterface add = Integer::sum;
        int result = add.operation(5, 3);
        log.info("Custom functional interface demo - Result of addition: {}", result);
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        int operation(int a, int b);
    }
}