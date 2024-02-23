package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ13904Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        7
                        4 60
                        4 40
                        1 20
                        2 50
                        3 30
                        4 10
                        6 5""", "185")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ13904().solve(input));
    }
}
