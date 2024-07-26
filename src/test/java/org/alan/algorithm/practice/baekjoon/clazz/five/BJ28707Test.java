package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ28707Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        1 4 3 2
                        4
                        1 2 4
                        2 3 3
                        3 4 2
                        1 4 10""", "7"),
                Arguments.of("""
                        4
                        1 3 1 3
                        6
                        1 2 3
                        1 3 3
                        1 4 3
                        2 3 3
                        2 4 1
                        3 4 1""", "2"),
                Arguments.of("""
                        5
                        1 3 1 2 5
                        6
                        1 2 3
                        1 3 3
                        1 4 3
                        2 3 3
                        2 4 1
                        3 4 1""", "2"),
                Arguments.of("""
                        5
                        5 4 3 2 1
                        2
                        1 2 5
                        3 4 3""", "-1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ28707().solve(input));
    }
}
