package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ22866Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        8
                        3 7 1 6 3 5 1 7""", """
                        1 2
                        0
                        3 2
                        2 2
                        4 4
                        3 4
                        4 6
                        0""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ22866().solve(input));
    }
}
