package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17071Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("0 0", "0"),
                Arguments.of("500000 500000", "0"),
                Arguments.of("0 1", "5"),
                Arguments.of("2 3", "1"),
                Arguments.of("6 6", "0"),
                Arguments.of("1 2", "3"),
                Arguments.of("5 17", "2"),
                Arguments.of("17 5", "4"),
                Arguments.of("7 37", "5"),
                Arguments.of("10 57", "5"),
                Arguments.of("21 70", "4"),
                Arguments.of("18 58", "4"),
                Arguments.of("18 66", "4"),
                Arguments.of("16 50", "4"),
                Arguments.of("34 0", "8"),
                Arguments.of("1 500000", "-1"),
                Arguments.of("250000 499999", "1"),
                Arguments.of("1 10", "6"),
                Arguments.of("300000 0", "-1"),
                Arguments.of("500000 0", "-1"),
                Arguments.of("8725 328744", "-1"),
                Arguments.of("27297 339652", "425"),
                Arguments.of("34768 292340", "-1"),
                Arguments.of("438 129118", "95"),
                Arguments.of("4040 160532", "385"),
                Arguments.of("250000 499994", "3"),
                Arguments.of("250000 499998", "-1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17071().solve(input));
    }
}
