package org.alan.algorithm.practice.baekjoon.barkingdog.segmenttree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2104Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        5""", "25"),
                Arguments.of("""
                        2
                        1 2""", "4"),
                Arguments.of("""
                        2
                        2 1""", "4"),
                Arguments.of("""
                        3
                        1 2 3""", "10"),
                Arguments.of("""
                        3
                        3 2 1""", "10"),
                Arguments.of("""
                        4
                        1 2 3 4""", "21"),
                Arguments.of("""
                        4
                        4 3 2 1""", "21"),
                Arguments.of("""
                        5
                        1 2 3 4 5""", "36"),
                Arguments.of("""
                        5
                        5 4 3 2 1""", "36"),
                Arguments.of("""
                        6
                        1 2 3 4 5 6""", "60"),
                Arguments.of("""
                        6
                        6 5 4 3 2 1""", "60"),
                Arguments.of("""
                        2
                        2 3""", "10"),
                Arguments.of("""
                        3
                        2 3 4""", "21"),
                Arguments.of("""
                        5
                        1 2 3 4 5""", "36"),
                Arguments.of("""
                        6
                        1 2 3 4 5 6""", "60"),
                Arguments.of("""
                        6
                        1 2 3 4 5 100""", "10000"),
                Arguments.of("""
                        6
                        3 1 6 4 5 2""", "60")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2104().solve(input));
    }
}
