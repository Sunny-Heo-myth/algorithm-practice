package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ14501Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
//                Arguments.of("""
//                        7
//                        3 10
//                        5 20
//                        1 10
//                        1 20
//                        2 15
//                        4 40
//                        2 200""", "45"),
                Arguments.of("""
                        10
                        1 1
                        1 2
                        1 3
                        1 4
                        1 5
                        1 6
                        1 7
                        1 8
                        1 9
                        1 10""", "55"),
                Arguments.of("""
                        10
                        5 10
                        5 9
                        5 8
                        5 7
                        5 6
                        5 10
                        5 9
                        5 8
                        5 7
                        5 6""", "20"),
                Arguments.of("""
                        10
                        5 50
                        4 40
                        3 30
                        2 20
                        1 10
                        1 10
                        2 20
                        3 30
                        4 40
                        5 50""", "90")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ14501().solve(input));
    }
}
