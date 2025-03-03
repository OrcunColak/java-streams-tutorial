package com.colak.collectors.teeing;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

// 1. Count how many live in Paris and
// 2. How many persons are emitted by the stream
@Slf4j
public class TeeingFindInParisOrCountTest {
    record Person(String name, String city, int age) {
    }

    public static void main() {

        List<Person> people = List.of(new Person("Alex", "Paris", 32),
                new Person("Martin", "Paris", 24),
                new Person("Tim", "Paris", 23),
                new Person("Emilie", "Berlin", 25),
                new Person("Albert", "Chicago", 24),
                new Person("Mateo", "Madrid", 25),
                new Person("Adrien", "Barcelone", 27));

        List<Long> result = people.stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(p -> p.city().equals("Paris"), // Collector 1
                                Collectors.counting()), // Collector 2
                        Collectors.counting(),
                        List::of)
                );

        // [3, 7]
        System.out.println(result);
    }

}
