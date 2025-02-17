package com.colak.stream.ofnullable;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class OfNullableTest {

    public static void main() {
        List<String> names = Arrays.asList("Alice", null, "Bob", "Charlie", null);
        List<String> filteredNames = names.stream()
                .flatMap(Stream::ofNullable)  //  Bye-bye, nulls!
                .collect(Collectors.toList());
        log.info("Filtered Names {}", filteredNames); // [Alice, Bob, Charlie]
    }
}
