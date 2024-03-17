package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10974Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3", """
                        1 2 3
                        1 3 2
                        2 1 3
                        2 3 1
                        3 1 2
                        3 2 1""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10974().solve(input));
    }
}
