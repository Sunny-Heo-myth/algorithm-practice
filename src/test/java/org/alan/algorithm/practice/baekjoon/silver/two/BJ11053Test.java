package org.alan.algorithm.practice.baekjoon.silver.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class BJ11053Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6
                        10 20 10 30 20 50""", "4"),
                Arguments.of("""
                        10
                        4 5 4 10 20 10 36 30 20 50""", "6"),
                Arguments.of("""
                        1
                        1""", "1"),
                Arguments.of("""
                        10
                        1 2 3 4 5 6 7 8 9 10""", "10"),
                Arguments.of("""
                        10
                        10 9 8 7 6 5 4 3 2 1""", "1"),
                Arguments.of("""
                        10
                        1 1 1 1 1 1 1 1 1 1""", "1"),
                Arguments.of("""
                        10
                        1 2 1 2 1 2 1 2 1 2""", "2"),
                Arguments.of("""
                        10
                        5 4 3 2 1 2 3 4 5 6""", "6")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11053().solve(input));
    }
}
