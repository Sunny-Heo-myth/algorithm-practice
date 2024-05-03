package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1743Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 4 5
                        3 2
                        2 2
                        3 1
                        2 3
                        1 1""", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1743().solve(input));
    }
}
