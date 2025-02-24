package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2169Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        5 5
                        10 25 7 8 13
                        68 24 -78 63 32
                        12 -69 100 -29 -25
                        -16 -22 -57 -33 99
                        7 -76 -11 77 15""", "319")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2169().solve(input));
    }
}
