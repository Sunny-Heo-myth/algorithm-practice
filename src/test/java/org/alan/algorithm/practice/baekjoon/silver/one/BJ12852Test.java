package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ12852Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2", """
                        1
                        2 1"""),
                Arguments.of("10", """
                        3
                        10 9 3 1""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ12852().solve(input));
    }
}
