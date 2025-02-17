package com.colak.stream.iterate;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class IterateTest {

    public static void main() {
        Stream.iterate(2, n -> n + 2)
                .limit(5)
                .forEach(System.out::println); // 2, 4, 6, 8, 10
    }
}
