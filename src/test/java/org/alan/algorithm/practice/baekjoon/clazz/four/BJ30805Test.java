package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ30805Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        1 9 7 3
                        5
                        1 8 7 5 3""", """
                        2
                        7 3"""),
                Arguments.of("""
                        5
                        1 9 7 3 5
                        5
                        1 8 7 5 3""", """
                        2
                        7 5"""),
                Arguments.of("""
                        1
                        1
                        1
                        1""", """
                        1
                        1"""),
                Arguments.of("""
                        1
                        1
                        1
                        2""", """
                        0""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ30805().solve(input));
    }
}
