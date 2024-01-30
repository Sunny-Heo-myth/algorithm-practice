package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2162Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3
                        1 1 2 3
                        2 1 0 0
                        1 0 1 1""", """
                        1
                        3"""),
                Arguments.of("""
                        3
                        -1 -1 1 1
                        -2 -2 2 2
                        0 1 -1 0""", """
                        2
                        2""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2162().solve2(input));
    }
}
