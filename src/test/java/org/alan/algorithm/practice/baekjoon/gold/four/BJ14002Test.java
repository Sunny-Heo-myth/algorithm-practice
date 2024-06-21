package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ14002Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6
                        10 20 10 30 20 50""", """
                        4
                        10 20 30 50"""),
                Arguments.of("""
                        6
                        10 20 30 20 10 30 20 50""", """
                        4
                        10 20 30 50"""),
                Arguments.of("""
                        6
                        10 15 20 30 20 10 30 20 50""", """
                        5
                        10 15 20 30 50"""),
                Arguments.of("""
                        6
                        10 15 25 18 20 30 20 10 30 20 50""", """
                        6
                        10 15 18 20 30 50""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ14002().solve(input));
    }


    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ14002().solve2(input));
    }
}
