package com.colak.streams.groupby.transformvalues;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// See https://medium.com/@ak123aryan/stream-group-by-interview-questions-ac3bc74d4953?source=explore---------19-98--------------------bc581852_01ce_4461_9d68_172de81a1069-------15

@Slf4j
class StreamGroupBySumValuesTest {

    public static void main() {
        List<Employee> employees = List.of(
                new Employee("John Doe", "dept1", "M", 1),
                new Employee("John Wick", "dept1", "M", 100),
                new Employee("Jane Smith", "dept2", "F", 2)
        );
        Map<String, Double> salarySumByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::department,
                                Collectors.summingDouble(Employee::salary)));

        // {dept1=101.0, dept2=2.0}
        log.info("sumByAttribute : {}", salarySumByDepartment);
    }

    record Employee(String name, String department, String gender, double salary) {
    }

}
