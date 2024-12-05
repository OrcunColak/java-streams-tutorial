package com.colak.streams.reduce;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
class ReduceTest {

    public static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        log.info("Sum : {}", sum);

    }
}
