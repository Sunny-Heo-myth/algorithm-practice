package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ13300Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        16 2
                        1 1
                        0 1
                        1 1
                        0 2
                        1 2
                        0 2
                        0 3
                        1 3
                        1 4
                        1 3
                        1 3
                        0 6
                        1 5
                        0 5
                        1 5
                        1 6""", "12"),
                Arguments.of("""
                        3 3
                        0 3
                        1 5
                        0 6""", "3")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ13300().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ13300().solve2(input));
    }

}
