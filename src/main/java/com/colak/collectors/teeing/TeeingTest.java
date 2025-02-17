package com.colak.collectors.teeing;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class TeeingTest {

    public static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Map<String, Optional<Integer>> minMax = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.maxBy(Integer::compare),  // Finds max
                        Collectors.minBy(Integer::compare),  // Finds min
                        (max, min) -> Map.of("Max", max, "Min", min)
                ));
        // Output: {Max=Optional[8], Min=Optional[1]}
        log.info("Map : {}", minMax);

    }
}
