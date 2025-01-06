package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ4883Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        13 7 5
                        7 13 6
                        14 3 12
                        15 6 16""", "1. 22"),
                Arguments.of("""
                        4
                        13 7 5
                        7 13 6
                        14 3 12
                        15 6 16""", "2. 22")
        );
    }

    static BJ4883 instance = new BJ4883();

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
