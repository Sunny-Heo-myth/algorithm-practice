package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16234Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        2 20 50
                        50 30
                        20 40""", "1"),
                Arguments.of("""
                        2 40 50
                        50 30
                        20 40""", "0"),
                Arguments.of("""
                        2 20 50
                        50 30
                        30 40""", "1"),
                Arguments.of("""
                        3 5 10
                        10 15 20
                        20 30 25
                        40 22 10""", "2"),
                Arguments.of("""
                        4 10 50
                        10 100 20 90
                        80 100 60 70
                        70 20 30 40
                        50 20 100 10""", "3")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16234().solve(input));
    }
}
