package org.alan.algorithm.practice.baekjoon.gold.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1082Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        2
                        1 50
                        50""", "1"),
                Arguments.of("""
                        2
                        2 1
                        10""", "1111111111"),
                Arguments.of("""
                        3
                        6 7 8
                        22""", "220"),
                Arguments.of("""
                        1
                        10
                        20""", "0"),
                Arguments.of("""
                        3
                        6 7 8
                        7""", "1"),
                Arguments.of("""
                        3
                        6 7 8
                        6""", "0"),
                Arguments.of("""
                        10
                        6 32 38 18 12 6 7 8 6 7
                        50""", "99888888"),
                Arguments.of("""
                        4
                        9 7 8 9
                        20""", "33"),
                Arguments.of("""
                        1
                        1
                        1""", "0"),
                Arguments.of("""
                        1
                        6 1 1 1
                        19""", "3333333333333333333"),
                Arguments.of("""
                        1
                        6
                        19""", "0"),
                Arguments.of("""
                        3
                        10 30 50
                        20""", "0"),
                Arguments.of("""
                        5
                        1 2 2 3 3
                        20""", "2000000000000000000"),
                Arguments.of("""
                        4
                        6 7 8 9
                        21""", "300"),
                Arguments.of("""
                        3
                        6 7 8
                        21""", "210"),
                Arguments.of("""
                        3
                        5 23 24
                        30""", "20"),
                Arguments.of("""
                        4
                        1 5 3 2
                        1""", "0"),
                Arguments.of("""
                        4
                        1 5 3 2
                        2""", "3"),
                Arguments.of("""
                        10
                        1 1 1 1 1 1 1 1 1 1
                        50""", "99999999999999999999999999999999999999999999999999")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1082().solve(input));
    }
}
