package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16139Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        seungjaehwang
                        4
                        a 0 5
                        a 0 6
                        a 6 10
                        a 7 10""", """
                        0
                        1
                        2
                        1"""),
                Arguments.of("""
                        seungjaehwang
                        2
                        s 0 1
                        s 1 2""", """
                        1
                        0""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16139().solve(input));
    }
}
