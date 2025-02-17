package com.colak.stream.dropwhile;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
class DropWhileTest {

    public static void main() {
        List<Integer> temperatures = List.of(15, 18, 19, 21, 22, 25, 30, 15);
        List<Integer> stableTemperatures = temperatures.stream()
                .dropWhile(temp -> temp < 20)
                .toList();

        // List : [21, 22, 25, 30, 15]
        log.info("List : {}", stableTemperatures);
    }
}
