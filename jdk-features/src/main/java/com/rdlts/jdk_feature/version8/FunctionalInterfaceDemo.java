package com.rdlts.jdk_feature.version8;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Log4j2
public class FunctionalInterfaceDemo {

    public static void demo() {
        predicateDemo();
        functionDemo();
        consumerDemo();
    }

    private static void predicateDemo() {
        Predicate<String> isNotEmpty = s -> s != null && !s.isEmpty();
        log.info("Predicate demo - Is 'test' not empty? {}", isNotEmpty.test("test"));
        log.info("Predicate demo - Is '' not empty? {}", isNotEmpty.test(""));
    }

    private static void functionDemo() {
        Function<String, Integer> stringLength = String::length;
        log.info("Function demo - Length of 'hello': {}", stringLength.apply("hello"));
    }

    private static void consumerDemo() {
        Consumer<String> printMessage = message -> log.info("Consumer demo - Message: {}", message);
        printMessage.accept("Hello, Consumer!");
    }
}