package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9662Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        20
                        3
                        1 2 3""", "5"),
                Arguments.of("""
                        999
                        1
                        1""", "499"),
                Arguments.of("""
                        1000000000
                        2
                        1 2""", "333333333"),
                Arguments.of("""
                        6543
                        5
                        2 4 7 11 20""", "1637"),
                Arguments.of("""
                        2191
                        4
                        1 6 14 22""", "779")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ9662().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ9662().solve2(input));
    }

}
