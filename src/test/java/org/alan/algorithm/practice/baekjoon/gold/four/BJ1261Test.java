package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1261Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                                1 1
                                0""", "0"),
                Arguments.of("""
                        2 2
                        01
                        10""", "1"),
                Arguments.of("""
                        2 2
                        01
                        00""", "0"),
                Arguments.of("""
                        3 3
                        011
                        111
                        110""", "3"),
                Arguments.of("""
                        4 2
                        0001
                        1000""", "0"),
                Arguments.of("""
                        4 2
                        0111
                        1110""", "3"),
                Arguments.of("""
                        6 6
                        001111
                        010000
                        001111
                        110001
                        011010
                        100010""", "2"),
                Arguments.of("""
                        10 10
                        0011110000
                        0100000110
                        0011111110
                        1100011110
                        0110101000
                        1000101011
                        1111101000
                        1001001110
                        1011111110
                        1000000000""", "1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1261().solve(input));
    }
}
