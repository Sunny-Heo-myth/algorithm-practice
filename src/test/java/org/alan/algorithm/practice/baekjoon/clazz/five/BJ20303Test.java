package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ20303Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        10 6 6
                        9 15 4 4 1 5 19 14 20 5
                        1 3
                        2 5
                        4 9
                        6 2
                        7 8
                        6 10""", "57"),
                Arguments.of("""
                        5 4 4
                        9 9 9 9 9
                        1 2
                        2 3
                        3 4
                        4 5""", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ20303().solve(input));
    }
}
