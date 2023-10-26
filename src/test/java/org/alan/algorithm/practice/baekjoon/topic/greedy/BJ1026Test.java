package org.alan.algorithm.practice.baekjoon.topic.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1026Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5\n" +
                        "1 1 1 6 0\n" +
                        "2 7 8 3 1", "18"),
                Arguments.of("3\n" +
                        "1 1 3\n" +
                        "10 30 20", "80"),
                Arguments.of("9\n" +
                        "5 15 100 31 39 0 0 3 26\n" +
                        "11 12 13 2 3 4 5 9 1", "528")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1026 instance = new BJ1026();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
