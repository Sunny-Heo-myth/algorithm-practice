package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ19644Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        1 2
                        0
                        3""", "NO"),
                Arguments.of("""
                        1
                        2 2
                        0
                        1""", "YES"),
                Arguments.of("""
                        1
                        2 2
                        0
                        3""", "NO"),
                Arguments.of("""
                        1
                        2 2
                        1
                        3""", "YES"),
                Arguments.of("""
                        6
                        3 2
                        1
                        2
                        4
                        6
                        6
                        6
                        8""", "YES"),
                Arguments.of("""
                        6
                        3 2
                        2
                        3
                        4
                        6
                        6
                        6
                        6""", "NO"),
                Arguments.of("""
                        10
                        3 2
                        3
                        2
                        4
                        8
                        8
                        8
                        2
                        4
                        6
                        6
                        6""", "YES"),
                Arguments.of("""
                        10
                        3 2
                        3
                        2
                        4
                        8
                        8
                        8
                        2
                        4
                        6
                        6
                        8""", "NO"),
                Arguments.of("""
                        7
                        1 4
                        1
                        8
                        1
                        2
                        1
                        3
                        1
                        2""", "YES"),
                Arguments.of("""
                        5
                        3 3
                        1
                        3
                        6
                        100
                        6
                        9""", "NO")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ19644().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ19644().solve2(input));
    }

}
