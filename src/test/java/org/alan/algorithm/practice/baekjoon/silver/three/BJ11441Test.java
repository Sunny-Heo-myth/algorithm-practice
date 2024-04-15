package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11441Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5
                        10 20 30 40 50
                        5
                        1 3
                        2 4
                        3 5
                        1 5
                        4 4""", """
                        60
                        90
                        120
                        150
                        40"""),
                Arguments.of("""
                        3
                        1 0 -1
                        6
                        1 1
                        2 2
                        3 3
                        1 2
                        2 3
                        1 3""", """
                        1
                        0
                        -1
                        1
                        -1
                        0""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11441().solve(input));
    }
}
