package com.colak.collectors.teeing;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Find min and max at the same time
@Slf4j
public class TeeingMinMaxTest {

    public static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Map<String, Optional<Integer>> minMax = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compare),  // Finds min
                        Collectors.maxBy(Integer::compare),  // Finds max

                        (min, max) -> Map.of("Min", min, "Max", max)
                ));
        // Output: {Min=Optional[1],Max=Optional[8]}
        log.info("Map : {}", minMax);

    }
}
