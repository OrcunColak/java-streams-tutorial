package com.colak.streams.takewhile;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
class TakeWhileTest {

    public static void main() {
        List<Integer> transactions = List.of(10, 20, 30, 40, 100, 150, 200, 10);

        List<Integer> smallTransactions = transactions.stream()
                .takeWhile(amount -> amount < 100)
                // [10, 20, 30, 40]
                .toList();

        log.info("List : {}", smallTransactions);
    }
}
