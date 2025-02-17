package com.colak.stream.groupby.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StreamGroupByBasicTest {

    public static void main() {

        List<Person> list = Arrays.asList(new Person("John", 25),
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Eve", 30));

        simpleGroupBy(list);
        simpleGroupByAndLambda(list);
    }

    private static void simpleGroupBy(List<Person> list) {
        Map<Integer, List<Person>> peopleByAge = list.
                stream().
                collect(
                        // the key of the map is age
                        Collectors.groupingBy(Person::age)
                );
        System.out.println(peopleByAge);
    }

    private static void simpleGroupByAndLambda(List<Person> list) {
        Map<String, List<Person>> peopleByAge = list.
                stream().
                collect(
                        // the key of the map is string
                        Collectors.groupingBy(
                                person -> {
                                    if (person.age() < 25) {
                                        return "young";
                                    } else if (person.age() < 50) {
                                        return "adult";
                                    } else {
                                        return "senior";
                                    }
                                }
                        )
                );
    }

    private record Person(String name, int age) {
    }

}
