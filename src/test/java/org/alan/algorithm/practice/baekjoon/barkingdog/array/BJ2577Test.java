package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2577Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        150
                        266
                        427""", """
                        3
                        1
                        0
                        2
                        0
                        0
                        0
                        2
                        0
                        0""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2577().solve(input));
    }
}
