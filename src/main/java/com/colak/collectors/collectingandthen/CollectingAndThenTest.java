package com.colak.collectors.collectingandthen;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CollectingAndThenTest {

    private static class Employee {
        private String name;
        @Getter
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

    }

    public static void main() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 5000),
                new Employee("Bob", 7000),
                new Employee("Charlie", 6000)
        );

        double roundedAverageSalary = employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.averagingDouble(Employee::getSalary),
                        avg -> Math.round(avg * 100.0) / 100.0 // Round to 2 decimal places
                ));

        System.out.println("Rounded Average Salary: " + roundedAverageSalary);
    }
}
