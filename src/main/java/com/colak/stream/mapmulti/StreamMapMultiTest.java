package com.colak.stream.mapmulti;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
class StreamMapMultiTest {

    public static void main() {

        filterAndMap();
        upperCaseLowerCase();
    }

    // extract only the even integers from the list.
    // when we call consumer.accept() from mapMulti the element is accepted
    private static void filterAndMap() {
        List<String> strings = List.of("1", "error", "42", "3", "banana", "4");
        var evenNumbers = strings.stream()
                .<Integer>mapMulti((line, consumer) -> {
                    try {
                        int number = Integer.parseInt(line);
                        if (number % 2 == 0) {
                            consumer.accept(number);
                        }
                    } catch (NumberFormatException ignored) {
                    }
                })
                .toList();
        // List : [A, a, B, b, C, c]
        log.info("evenNumbers : {}", evenNumbers);
    }

    // when we call consumer.accept() from mapMulti the element is accepted
    private static void upperCaseLowerCase() {
        List<String> strings = List.of("a", "b", "c");

        List<String> result = strings.stream()
                .<String>mapMulti((element, consumer) -> {
                    consumer.accept(element.toUpperCase());
                    consumer.accept(element.toLowerCase());
                })
                .toList();

        // List : [A, a, B, b, C, c]
        log.info("List : {}", result);
    }


}


