package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1707Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 2
                        1 3
                        2 3""", "YES"),
                Arguments.of("""
                        4 4
                        1 2
                        2 3
                        3 4
                        4 2""", "NO"),
                Arguments.of("""
                        8 8
                        1 2
                        2 3
                        3 4
                        4 5
                        5 6
                        6 7
                        7 8
                        8 1""", "YES"),
                Arguments.of("""
                        7 7
                        1 2
                        2 3
                        3 4
                        4 5
                        5 6
                        6 7
                        7 1""", "NO")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1707().solve(input));
    }
}
