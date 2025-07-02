package org.alan.algorithm.practice.baekjoon.barkingdog.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2533Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        2
                        1 2""", "1"),
                Arguments.of("""
                        8
                        1 2
                        1 3
                        1 4
                        2 5
                        2 6
                        4 7
                        4 8""", "3"),
                Arguments.of("""
                        9
                        1 2
                        1 3
                        2 4
                        3 5
                        3 6
                        4 7
                        4 8
                        4 9""", "3"),
                Arguments.of("""
                        22
                        1 2
                        1 3
                        1 4
                        2 5
                        5 6
                        5 7
                        7 8
                        7 9
                        3 10
                        3 11
                        11 14
                        14 15
                        4 12
                        4 13
                        13 19
                        12 16
                        12 17
                        12 18
                        18 20
                        20 21
                        20 22""", "8"),
                Arguments.of("""
                        22
                        1 4
                        2 1
                        3 1
                        5 2
                        6 2
                        19 5
                        20 5
                        6 21
                        6 22
                        19 11
                        19 12
                        20 13
                        14 20
                        15 21
                        16 21
                        17 22
                        22 18
                        7 11
                        8 11
                        9 12
                        12 10""", "8")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
//        Assertions.assertEquals(expected, new BJ2533().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
//        Assertions.assertEquals(expected, new BJ2533().solve2(input));
    }

}
