package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1781Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        7
                        1 6
                        1 7
                        3 2
                        3 1
                        2 4
                        2 5
                        6 1""", "15")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1781().solve(input));
    }
}
