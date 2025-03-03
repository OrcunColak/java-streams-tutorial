package com.colak.collectors.teeing;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 1. Find the minimum age from the list of Person objects
// 2. Find the maximum age from the list of Person objects
@Slf4j
public class TeeingMinMaxAgeTest {
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

        String minMaxAge = people.stream().collect(
                Collectors.teeing(
                        Collectors.minBy(Comparator.comparingInt(Person::age)),
                        Collectors.maxBy(Comparator.comparingInt(Person::age)),
                        (min, max) -> "Min = " + min.get() + ", Max = " + max.get() // Merge
                )
        );
        System.out.println(minMaxAge);
    }

}
