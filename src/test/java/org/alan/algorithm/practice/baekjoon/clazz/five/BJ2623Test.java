package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2623Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6 3
                        3 1 4 3
                        4 6 2 5 4
                        2 2 3""", """
                        6
                        2
                        1
                        5
                        4
                        3""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2623().solve(input));
    }
}
