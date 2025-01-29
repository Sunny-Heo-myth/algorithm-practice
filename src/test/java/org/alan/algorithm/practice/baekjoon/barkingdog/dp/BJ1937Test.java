package org.alan.algorithm.practice.baekjoon.barkingdog.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1937Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        14""", "1"),
                Arguments.of("""
                        2
                        14 2
                        3 12""", "2"),
                Arguments.of("""
                        2
                        1 2
                        4 3""", "4"),
                Arguments.of("""
                        4
                        14 9 12 10
                        1 11 5 4
                        7 15 2 13
                        6 3 16 8""", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1937().solve(input));
    }
}
