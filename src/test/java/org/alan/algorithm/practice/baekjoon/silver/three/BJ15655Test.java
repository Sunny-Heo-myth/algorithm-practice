package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15655Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 1
                        4 5 2""", """
                        2
                        4
                        5"""),
                Arguments.of("""
                        4 2
                        9 8 7 1""", """
                        1 7
                        1 8
                        1 9
                        7 8
                        7 9
                        8 9"""),
                Arguments.of("""
                        4 4
                        1231 1232 1233 1234""", """
                        1231 1232 1233 1234""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15655().solve(input));
    }
}
