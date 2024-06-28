package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11049Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3
                        5 3
                        3 2
                        2 6""", "90"),
                Arguments.of("""
                        5
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1""", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11049().solve(input));
    }
}
