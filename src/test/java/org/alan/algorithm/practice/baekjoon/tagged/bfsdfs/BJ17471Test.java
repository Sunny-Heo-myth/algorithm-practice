package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17471Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        6
                        5 2 3 4 1 2
                        2 2 4
                        4 1 3 6 5
                        2 4 2
                        2 1 3
                        1 2
                        1 2""", "1"),
                Arguments.of("""
                        6
                        1 1 1 1 1 1
                        2 2 4
                        4 1 3 6 5
                        2 4 2
                        2 1 3
                        1 2
                        1 2""", "0"),
                Arguments.of("""
                        6
                        10 20 10 20 30 40
                        0
                        0
                        0
                        0
                        0
                        0""", "-1"),
                Arguments.of("""
                        6
                        2 3 4 5 6 7
                        2 2 3
                        2 1 3
                        2 1 2
                        2 5 6
                        2 4 6
                        2 4 5""", "9")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17471().solve(input));
    }

}
