package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10942Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        7
                        1 2 1 3 1 2 1
                        4
                        1 3
                        2 5
                        3 3
                        5 7""", """
                        1
                        0
                        1
                        1""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10942().solve(input));
    }
}
