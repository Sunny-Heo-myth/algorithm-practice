package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ3015Test {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        7
                        2
                        4
                        1
                        2
                        2
                        5
                        1""", "10"),
                Arguments.of("""
                        7
                        1
                        2
                        3
                        4
                        5
                        6
                        7""", "6"),
                Arguments.of("""
                        7
                        1
                        1
                        1
                        1
                        1
                        1
                        1""", "21"),
                Arguments.of("""
                        7
                        1
                        2
                        3
                        4
                        3
                        2
                        1""", "6"),
                Arguments.of("""
                        7
                        4
                        3
                        2
                        1
                        2
                        3
                        4""", "13")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3015().solve(input));
    }

}
