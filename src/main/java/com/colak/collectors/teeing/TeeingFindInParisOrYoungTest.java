package com.colak.collectors.teeing;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

// 1. Find the list of persons living in Paris
// 2. The list of persons 24 years of age
@Slf4j
public class TeeingFindInParisOrYoungTest {
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

        List<List<Person>> result = people.stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(p -> p.city().equals("Paris"), // Collector 1
                                Collectors.toList()),
                        Collectors.filtering(p -> 24 == p.age(), // Collector 2
                                Collectors.toList()),
                        List::of
                ));

        // [[Person[name=Alex, city=Paris, age=32], Person[name=Martin, city=Paris, age=24], Person[name=Tim, city=Paris, age=23]], [Person[name=Martin, city=Paris, age=24], Person[name=Albert, city=Chicago, age=24]]]
        System.out.println(result);
    }

}
