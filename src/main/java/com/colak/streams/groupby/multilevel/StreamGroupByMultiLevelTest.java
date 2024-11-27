package com.colak.streams.groupby.multilevel;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
class StreamGroupByMultiLevelTest {

    public static void main() {
        List<Employee> employees = List.of(
                new Employee("John", "Sales", "North"),
                new Employee("Alice", "Sales", "South"),
                new Employee("Bob", "Marketing", "East"),
                new Employee("Charlie", "Marketing", "West")
        );

        multiLevelGrouping(employees);
    }

    private static void multiLevelGrouping(List<Employee> employees) {
        // First group by department then for each department group by gender
        Map<String, Map<String, List<Employee>>> byDeptThenGender =
                employees.stream()
                        // group employees by department, and again to group them by team within each department.
                        .collect(Collectors.groupingBy(Employee::department,
                                Collectors.groupingBy(Employee::team)));

        // { "Sales": { "North": [Employee("John", "Sales", "North")],
        //              "South": [Employee("Alice", "Sales", "South")]
        //            },
        //   "Marketing": { "East": [Employee("Bob", "Marketing", "East")],
        //                   "West": [Employee("Charlie", "Marketing", "West")]
        //                 }
        // }
        log.info("multiLevelGrouping : {}", byDeptThenGender);
    }

    private record Employee(String name, String department, String team) {
    }
}
